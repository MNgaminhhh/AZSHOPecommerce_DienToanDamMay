package Controllers.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Models.Product;
import Services.IProductService;
import Services.Impl.ProductService;

@WebServlet(urlPatterns = { "/admin/product/list", "/admin/product/insert", "/admin/product/update",
		"/admin/product/delete" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IProductService proService = new ProductService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("admin/product/list")) {
			getList(req,resp);
		} else if (url.contains("insert")) {
			getInsert(req,resp);
		} else if (url.contains("update")) {
			getUpdate(req,resp);
		} else if (url.contains("delete")) {
			getDelete(req,resp);
		}

	}
	protected void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = proService.findAll();
		req.setAttribute("products", products);
		req.getRequestDispatcher("/Views/admin/product/list.jsp").forward(req, resp);
	}
	protected void getInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/admin/product/insert.jsp").forward(req, resp);
	}
	protected void getUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = proService.findByID(Integer.parseInt(req.getParameter("product_id")));
		req.setAttribute("product", product);		
		req.getRequestDispatcher("/Views/admin/product/update.jsp").forward(req, resp);
	}
	protected void getDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			proService.Delete(Integer.parseInt(req.getParameter("product_id")));
			req.setAttribute("message", "Xoa thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Xoa that bai");
		}
		resp.sendRedirect(req.getContextPath()+"/admin/product/list");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("admin/product/insert")) {
			postInsert(req, resp);
		}else if (url.contains("admin/product/update")) {
			postUpdate(req, resp);
		}
	}

	private void postInsert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Product product = new Product();
		try {
			BeanUtils.populate(product, req.getParameterMap());
			proService.Insert(product);
			req.setAttribute("message", "Them thanh cong");
		} catch (Exception e) {
			req.setAttribute("error", "Them that bai");
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath()+"/admin/product/list");
	}

	private void postUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Product product = new Product();
		try {
			BeanUtils.populate(product, req.getParameterMap());
			proService.Update(product);
			req.setAttribute("message", "Chinh sua thanh cong");
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Chinh sua that bai");
		}
		resp.sendRedirect(req.getContextPath() + "/admin/product/list");
	}

}
