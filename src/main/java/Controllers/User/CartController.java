package Controllers.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Cart;
import Models.User;
import Services.ICartSerive;
import Services.Impl.CartService;

@WebServlet(urlPatterns = { "/user/cart", "/user/update-cart", "/user/delete-cart", "/user/add-cart" })
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ICartSerive cartService = new CartService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("/user/cart")) {
			getCart(req, resp);
		} else if (url.contains("/user/update-cart")) {
			getUpdate(req, resp);
		} else if (url.contains("/user/delete-cart")) {
			getDelete(req, resp);
		}
	}

	private void getDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		cartService.delete(Integer.parseInt(req.getParameter("cart_id")));
		resp.sendRedirect(req.getContextPath() + "/user/cart");
	}

	private void getUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart = cartService.findById(Integer.parseInt(req.getParameter("cart_id")));
		int new_quantity;
		if ("true".equals(req.getParameter("isCheck"))) {
			new_quantity = Integer.parseInt(req.getParameter("quantity"));
		} else {
			new_quantity = cart.getQuantity() + Integer.parseInt(req.getParameter("quantity"));	
		}
		if (new_quantity == 0) {
			cartService.delete(cart.getCart_id());
		}else {
			cart.setQuantity(new_quantity);
			cartService.update(cart);	
		}
		resp.sendRedirect(req.getContextPath() + "/user/cart");
	}

	private void getCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		if (req.getParameter("message") != null) {
			req.setAttribute("message", "Có sản phẩm hết hàng");
		}
		User u = (User) session.getAttribute("account");
		int user_id = u.getUserID();
		List<Cart> carts = cartService.findByUserID(user_id);
		req.setAttribute("carts", carts);

		float total = 0;
		for (Cart cart : carts) {
			total += cart.getTotal_price();
		}

		req.setAttribute("total", total);

		req.getRequestDispatcher("/Views/user/cart.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("/user/add-cart")) {
			postAdd(req,resp);
		}
	}

	private void postAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Đọc dữ liệu từ InputStream
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        String inputString = sb.toString();
        String[] parts = inputString.split(",");
        
        
        HttpSession session = req.getSession();
		User u = (User) session.getAttribute("account");
		if (u != null) {
			int user_id = u.getUserID();
			int quantity = Integer.parseInt(parts[0].toString());
			int product_id = Integer.parseInt(parts[1].toString());
			Cart cart = cartService.findByUserIDAndProductId(user_id, product_id);
			if (cart.getCart_id() == 0) {
				Cart new_cart = new Cart(0, user_id, product_id, quantity);
				cartService.insert(new_cart);
				resp.sendRedirect(req.getContextPath() + "/product-detail?product_id="+String.valueOf(product_id));	
			}
			else {
				quantity += cart.getQuantity();
				cart.setQuantity(quantity);
				cartService.update(cart);
				resp.sendRedirect(req.getContextPath() + "/product-detail?product_id="+String.valueOf(product_id));
			}
		}else {
			resp.sendRedirect(req.getContextPath() + "/user/login");
		}
	}
}
