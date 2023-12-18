package Controllers.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Category;
import Models.Product;
import Models.Supplier;
import Models.User;
import Models.ViewedProduct;
import Services.ICategoryService;
import Services.IProductService;
import Services.ISupplierService;
import Services.IViewedProductService;
import Services.Impl.CategoryService;
import Services.Impl.ProductService;
import Services.Impl.SupplierService;
import Services.Impl.ViewedProductService;

@WebServlet(urlPatterns = { "/home", "/product-detail", "/search", "/loadAjax" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICategoryService cateService = new CategoryService();
	private IProductService proService = new ProductService();
	private ISupplierService supplierService = new SupplierService();
	private IViewedProductService vpService = new ViewedProductService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Set attribute
		List<Category> categories = cateService.findAll();
		for (Category i : categories) {
			i.setCount(cateService.countProduct(i.getCategory_id()));
		}
		req.setAttribute("categories", categories);
		List<Supplier> suppliers = supplierService.findAll();
		for (Supplier i : suppliers) {
			i.setCount(supplierService.countProduct(i.getSupplier_id()));
		}
		req.setAttribute("suppliers", suppliers);

		// Handle Servlet
		String url = req.getRequestURI().toString();
		if (url.contains("home")) {
			getHome(req, resp);
		} else if (url.contains("product-detail")) {
			getProductDetail(req, resp);
		} else if (url.contains("loadAjax")) {
			getHomeAjax(req, resp);
		}
	}

	private void getHomeAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int existingCount = 0;
		String existingCountParam = req.getParameter("exists");
		String indexPage = req.getParameter("indexPage");
		if (existingCountParam != null && indexPage != null) {
			existingCount = Integer.parseInt(existingCountParam);
		}
		if (existingCount < 15) {
			List<Product> products;
			if (Integer.parseInt(req.getParameter("category_id")) != 0) {
				products = proService.findTop3ByCategory(Integer.parseInt(req.getParameter("category_id")),
						existingCount + (Integer.parseInt(indexPage) - 1) * 15);
			} else if (Integer.parseInt(req.getParameter("supplier_id")) != 0) {
				products = proService.findTop3BySupplier(Integer.parseInt(req.getParameter("supplier_id")),
						existingCount + (Integer.parseInt(indexPage) - 1) * 15);
			} else if (Integer.parseInt(req.getParameter("end_range")) != 0) {
				products = proService.findTop3ByPrice(Integer.parseInt(req.getParameter("start_range")),
						Integer.parseInt(req.getParameter("end_range")),
						existingCount + (Integer.parseInt(indexPage) - 1) * 15);
			} else {
				products = proService.findTop3(existingCount + (Integer.parseInt(indexPage) - 1) * 15);
			}

			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("account");
			int user_id = 0;
			if (u != null) {
				user_id = u.getUserID();
				req.setAttribute("user_id", user_id);
			}

			PrintWriter out = resp.getWriter();
			for (Product product : products) {
				NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
				String giaSanPhamVND = currencyFormat.format(product.getPrice());
				out.println("<div class=\"productAjax col-sm-4\">\r\n"
						+ "									<div class=\" product-image-wrapper single-products\">\r\n"
						+ "										<div class=\"productinfo text-center\">\r\n"
						+ "											<a\r\n"
						+ "												href=\"/AZSHOP/product-detail?product_id="
						+ product.getProduct_id() + "\">\r\n"
						+ "												<img style=\"width: auto; height: 134px\"\r\n"
						+ "												src=\"templates/images/product/"
						+ product.getImage() + "\" alt=\"\" />\r\n"
						+ "											</a>\r\n"
						+ "											<h2>\r\n"
						+ "											"+ giaSanPhamVND +"\r\n"
						+ "											</h2>\r\n"
						+ "											<p>" + product.getProduct_name() + "</p>\r\n"
						+ "											<button type=\"button\" class=\"btn btn-default add-to-cart\"\r\n"
						+ "												id=\"addToCart\"\r\n"
						+ "												onclick=\"clickToAddCart(" + user_id + ", "
						+ product.getProduct_id() + ", 1)\">\r\n"
						+ "												<i class=\"fa fa-shopping-cart\"></i>Add to cart\r\n"
						+ "											</button>\r\n" + "\r\n"
						+ "										</div>\r\n"
						+ "									</div>\r\n" + "								</div>");
			}
		}

	}

	private void getProductDetail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// Handle slider
		List<Product> bestSelling = proService.findBestSellingProdut();
		
		if (bestSelling != null && !bestSelling.isEmpty()) {
			req.setAttribute("bestSelling_active", bestSelling.get(0));
		
			if (bestSelling.size() > 1) {
				req.setAttribute("bestSelling1", bestSelling.get(1));
			}
		
			if (bestSelling.size() > 2) {
				req.setAttribute("bestSelling2", bestSelling.get(2));
			}
		} else {
			// Handle the case when bestSelling is null or empty
			// You may want to set default values or provide an appropriate message
			req.setAttribute("bestSelling_active", null);
			req.setAttribute("bestSelling1", null);
			req.setAttribute("bestSelling2", null);
		}
		// Handle Product
		Product product;
		if (req.getParameter("product_id") == null || req.getParameter("product_id").isEmpty()) {
			product = proService.findByID(1);
		} else {
			int product_id = Integer.parseInt(req.getParameter("product_id"));
			product = proService.findByID(product_id);
		}
		req.setAttribute("product", product);

		Supplier supplier = supplierService.findById(product.getSupplier_id());
		req.setAttribute("supplier", supplier);

		// Handle sup image
		String[] images = product.getImages().split(",");
		List<List<String>> matrix_image = new ArrayList<>();

		for (int i = 0; i < images.length; i += 3) {
			int endIndex = Math.min(i + 3, images.length);
			List<String> row = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(images, i, endIndex)));
			matrix_image.add(row);
		}

		req.setAttribute("images_active", matrix_image.get(0));
		req.setAttribute("images", matrix_image.subList(1, matrix_image.size()));

		// Handle product same category
		List<Product> products_same_category = proService.findByCategory(product.getCategory_id());
		List<List<Product>> matrix_same_cate = new ArrayList<>();

		for (int i = 0; i < products_same_category.size(); i += 3) {
			int endIndex = Math.min(i + 3, products_same_category.size());
			List<Product> row = new ArrayList<>(products_same_category.subList(i, endIndex));
			matrix_same_cate.add(row);
		}

		req.setAttribute("same_cate_active", matrix_same_cate.get(0));
		req.setAttribute("same_cate", matrix_same_cate.subList(1, matrix_same_cate.size()));

		// Handle product same supplier
		List<Product> products_same_supplier = proService.findBySupplier(product.getSupplier_id());
		List<List<Product>> matrix_same_supplier = new ArrayList<>();

		for (int i = 0; i < products_same_supplier.size(); i += 3) {
			int endIndex = Math.min(i + 3, products_same_supplier.size());
			List<Product> row = new ArrayList<>(products_same_supplier.subList(i, endIndex));
			matrix_same_supplier.add(row);
		}

		req.setAttribute("same_supplier_active", matrix_same_supplier.get(0));
		req.setAttribute("same_supplier", matrix_same_supplier.subList(1, matrix_same_supplier.size()));

		// Handle viewed product
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("account");
		int user_id = 0;
		if (u != null) {
			user_id = u.getUserID();
		}
		List<ViewedProduct> viewedproducts = vpService.findByUserId(user_id);
		boolean check = true;
		ViewedProduct vp = new ViewedProduct();
		vp.setUserID(user_id);
		vp.setProductID(product.getProduct_id());
		vp.setViewdate(new java.sql.Date(new java.util.Date().getTime()));

		List<Product> products_viewed = new ArrayList<>();
		for (ViewedProduct item : viewedproducts) {
			products_viewed.add(proService.findByID(item.getProductID()));
			if (item.getProductID() == vp.getProductID())
				check = false;
		}
		if (check) {
			vpService.insert(vp);
			products_viewed.add(proService.findByID(vp.getProductID()));
		}
		List<List<Product>> matrix_same_vp = new ArrayList<>();

		for (int i = 0; i < products_viewed.size(); i += 3) {
			int endIndex = Math.min(i + 3, products_viewed.size());
			List<Product> row = new ArrayList<>(products_viewed.subList(i, endIndex));
			matrix_same_vp.add(row);
		}

		req.setAttribute("viewed_product_active", matrix_same_vp.get(0));
		req.setAttribute("viewed_product", matrix_same_vp.subList(1, matrix_same_vp.size()));
		req.setAttribute("user_id", user_id);

		req.getRequestDispatcher("Views/web/product-detail.jsp").forward(req, resp);
	}

	private void getHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// Handle index page
		String indexPage = req.getParameter("indexPage");
		if (indexPage == null) {
			indexPage = "1";
		}
		int indexp = Integer.parseInt(indexPage);
		int countP = proService.countAllProduct();
		int endPage = countP/15;
		if (countP % 15 != 0) {
			endPage++;
		}
		// Get user id
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("account");
		int user_id = 0;
		if (u != null) {
			user_id = u.getUserID();
			req.setAttribute("user_id", user_id);
		}

		// Handle slider
		List<Product> bestSelling = proService.findBestSellingProdut();

		if (bestSelling != null && !bestSelling.isEmpty()) {
			req.setAttribute("bestSelling_active", bestSelling.get(0));
			if (bestSelling.size() > 1) {
				req.setAttribute("bestSelling1", bestSelling.get(1));
			}
			if (bestSelling.size() > 2) {
				req.setAttribute("bestSelling2", bestSelling.get(2));
			}
		} else {
			// Thực hiện xử lý hoặc hiển thị thông báo lỗi tùy thuộc vào yêu cầu của bạn
			req.setAttribute("message", "Không có sản phẩm bán chạy.");
		}
		// Clean bảng các sản phẩm đã xem
		vpService.CleanTable();

		// Get product list
		List<Product> all_pro;
		List<Product> list_pro = new ArrayList<>();
		int category_id = 0;
		int supplier_id = 0;
		float start_range = 0, end_range = 0;
		if (req.getParameter("category_id") != null) {
			category_id = Integer.parseInt(req.getParameter("category_id"));
			list_pro = proService.findTop3ByCategory(category_id, 0);
		} else if (req.getParameter("supplier_id") != null) {
			supplier_id = Integer.parseInt(req.getParameter("supplier_id"));
			list_pro = proService.findTop3BySupplier(supplier_id, 0);
		} else if (req.getParameter("price_range") != null) {
			int price_range = Integer.parseInt(req.getParameter("price_range"));
			if (price_range == 1) {
				start_range = 0;
				end_range = 100;
			} else if (price_range == 2) {
				start_range = 100;
				end_range = 500;
			} else if (price_range == 3) {
				start_range = 500;
				end_range = 1000;
			} else if (price_range == 4) {
				start_range = 1000;
				end_range = 2000;
			} else if (price_range == 5) {
				start_range = 2000;
				end_range = 999999;
			}
			list_pro = proService.findTop3ByPrice(start_range, end_range, 0);
		} else {
			list_pro = proService.findTop3((indexp-1)*15);
		}
		if (list_pro != null) {
			// Set attribute
			req.setAttribute("products", list_pro);
			req.setAttribute("category_id", category_id);
			req.setAttribute("supplier_id", supplier_id);
			req.setAttribute("start_range", start_range);
			req.setAttribute("end_range", end_range);
			req.setAttribute("indexp", indexp);
			req.setAttribute("endPage", endPage);
	
		} else {
			req.setAttribute("message", "Không có sản phẩm");
		}
		// Render page
		req.getRequestDispatcher("Views/web/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("search")) {
			postSearch(req, resp);
		}
	}

	private void postSearch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String searchValue = req.getParameter("searchInput");
		List<Product> products = proService.findByName(searchValue);
		System.out.println(products.toString());
		if (products.size() == 0) {
			req.setAttribute("message", "Không có sản phẩm");
		}
		req.setAttribute("products", products);
		req.setAttribute("categories", cateService.findAll());
		List<Supplier> suppliers = supplierService.findAll();
		for (Supplier i : suppliers) {
			i.setCount(supplierService.countProduct(i.getSupplier_id()));
		}
		req.setAttribute("suppliers", suppliers);
		// Chuyển hướng sau khi xử lý tìm kiếm
		req.getRequestDispatcher("Views/web/home.jsp").forward(req, resp);
	}

}
