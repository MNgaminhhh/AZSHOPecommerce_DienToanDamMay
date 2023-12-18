package Controllers.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import Models.Bill;
import Models.BillDetail;
import Models.Product;
import Models.User;
import Services.IBillDetailService;
import Services.IBillService;
import Services.ICartSerive;
import Services.IProductService;
import Services.IUserService;
import Services.Impl.BillDetailService;
import Services.Impl.BillService;
import Services.Impl.CartService;
import Services.Impl.ProductService;
import Services.Impl.UserSerive;

@WebServlet(urlPatterns = { "/user/about", "/user/account", "/user/wishlist", "/user/history", "/user/billDetails"})
public class UserController extends HttpServlet {

	IUserService userService = new UserSerive();
	IProductService productService = new ProductService();
	ICartSerive cartService = new CartService();
	IBillService billService = new BillService();
	IBillDetailService billdetailService = new BillDetailService();
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("/user/account")) {
			getAccount(req, resp);
		} else if (url.contains("/user/wishlist")) {
			getWishlist(req, resp);
		} else if (url.contains("/user/history")) {
			getHistory(req, resp);
		} else if (url.contains("/user/about")) {
			getAbout(req, resp);
		} else if (url.contains("/user/billDetails")) {
			billdetail(req, resp);
		}
	}

	private void billdetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int billId = Integer.parseInt(req.getParameter("billId"));
		List<BillDetail> billDetails = billdetailService.findBilDetailByBillID(billId);
		for (BillDetail detail : billDetails) {
            Product product = productService.findByID(detail.getProductID()); 
            detail.setProduct(product);
        }
		req.setAttribute("billdetail", billDetails);
		req.getRequestDispatcher("/Views/user/billdetail.jsp").forward(req, resp);
	}
	

	private void getAbout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/user/aboutShop.jsp").forward(req, resp);
	}

	private void getHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			int userid = u.getUserID();
			List<Bill> bills = billService.findByUserID(userid);
	        req.setAttribute("bills", bills);
	        System.out.println(bills.toString());
			req.getRequestDispatcher("/Views/user/history.jsp").forward(req, resp);
		} else {
        	resp.sendRedirect(req.getContextPath() + "/user/login");
        }
		
	}

	private void getWishlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/user/wishlist.jsp").forward(req, resp);
	}

	private void getAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			String username = u.getUserName();
			String email = u.getEmail();
			
			req.setAttribute("username", username);
			req.setAttribute("email", email);
            
            req.getRequestDispatcher("/Views/user/account.jsp").forward(req, resp);
        } else {
        	resp.sendRedirect(req.getContextPath() + "/user/login");
        }
	}
}
