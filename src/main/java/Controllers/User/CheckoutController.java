package Controllers.User;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Config.Config;
import Models.Bill;
import Models.BillDetail;
import Models.Cart;
import Models.Product;
import Models.User;
import Services.IBillDetailService;
import Services.IBillService;
import Services.ICartSerive;
import Services.IProductService;
import Services.Impl.BillDetailService;
import Services.Impl.BillService;
import Services.Impl.CartService;
import Services.Impl.ProductService;

@WebServlet(urlPatterns = { "/user/checkout", "/user/thanks", "/user/addbill", "/user/paymentMethodCart",
		"/user/vnpayajax" })
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICartSerive cartService = new CartService();
	IProductService proService = new ProductService();
	IBillService billService = new BillService();
	IBillDetailService billDetailService = new BillDetailService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("checkout")) {
			getCheckout(req, resp);
		} else if (url.contains("thanks")) {
			getThanks(req, resp);
		} else if (url.contains("addbill")) {
			getBill(req, resp);
		} else if (url.contains("paymentMethodCart")) {
			getPaymentMethodCart(req, resp);
		}

	}

	private void getPaymentMethodCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("total_amount", (int)Math.round(Double.parseDouble(req.getParameter("total_amount"))));
		req.getRequestDispatcher("/Views/user/paymentMethodCart.jsp").forward(req, resp);
	}
	
	private void getBill(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("account");
		int user_id = u.getUserID();
		java.util.Date order_date = new java.util.Date();
		String total_amount = req.getParameter("total_amount");
		Bill bill = new Bill();
		bill.setUser_id(user_id);
		bill.setOrder_date(new java.sql.Date(order_date.getTime()));
		bill.setTotal_amount(new BigDecimal(total_amount));
		bill.setReceiver(req.getParameter("receiver"));
		bill.setPhone(req.getParameter("phone"));
		bill.setAddress(req.getParameter("address"));

		billService.insert(bill);

		List<Cart> carts = cartService.findByUserID(user_id);
		for (Cart cart : carts) {
			BillDetail billdetail = new BillDetail();
			billdetail.setBillID(billService.findNewestBillByUserID(user_id).getBill_id());
			billdetail.setProductID(cart.getProduct_id());
			billdetail.setQuantity(cart.getQuantity());
			billdetail.setPrice(new BigDecimal(cart.getTotal_price()));
			billDetailService.insert(billdetail);
			
			cartService.delete(cart.getCart_id());
			
			Product p = proService.findByID(cart.getProduct_id());
			int new_stock = p.getStock_quantity() - cart.getQuantity();
			int new_sold = p.getSold_quantity() + cart.getQuantity();
			p.setStock_quantity(new_stock);
			p.setSold_quantity(new_sold);
			proService.Update(p);
		}
	}

	private void getThanks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/user/thanks.jsp").forward(req, resp);
	}

	private void getCheckout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("account");
		int user_id = u.getUserID();
		List<Cart> carts = cartService.findByUserID(user_id);
		//Handle stock
		boolean isCheck = true;
		for (Cart cart : carts) {
			Product p = proService.findByID(cart.getProduct_id());
			if (cart.getQuantity() > p.getStock_quantity()) {
				isCheck = false;
				break;
			}
		}
		if (isCheck) {
			req.setAttribute("carts", carts);

			float total = 0;
			for (Cart cart : carts) {
				total += cart.getTotal_price();
			}

			req.setAttribute("total", total);
			int shipCost = 10;
			req.setAttribute("total_amount", total + shipCost);

			req.getRequestDispatcher("/Views/user/checkout.jsp").forward(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/user/cart?message=true");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String vnp_Version = "2.1.0";
		String vnp_Command = "pay";
		String orderType = "other";
		long amount = Integer.parseInt(req.getParameter("amount")) * 100;
		String bankCode = req.getParameter("bankCode");

		String vnp_TxnRef = Config.getRandomNumber(8);
		String vnp_IpAddr = Config.getIpAddress(req);

		String vnp_TmnCode = Config.vnp_TmnCode;

		Map<String, String> vnp_Params = new HashMap<>();
		vnp_Params.put("vnp_Version", vnp_Version);
		vnp_Params.put("vnp_Command", vnp_Command);
		vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
		vnp_Params.put("vnp_Amount", String.valueOf(amount));
		vnp_Params.put("vnp_CurrCode", "VND");

		if (bankCode != null && !bankCode.isEmpty()) {
			vnp_Params.put("vnp_BankCode", bankCode);
		}
		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
		vnp_Params.put("vnp_OrderType", orderType);

		String locate = req.getParameter("language");
		if (locate != null && !locate.isEmpty()) {
			vnp_Params.put("vnp_Locale", locate);
		} else {
			vnp_Params.put("vnp_Locale", "vn");
		}
		vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
		vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

		cld.add(Calendar.MINUTE, 15);
		String vnp_ExpireDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

		List fieldNames = new ArrayList(vnp_Params.keySet());
		Collections.sort(fieldNames);
		StringBuilder hashData = new StringBuilder();
		StringBuilder query = new StringBuilder();
		Iterator itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = (String) vnp_Params.get(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0)) {
				// Build hash data
				hashData.append(fieldName);
				hashData.append('=');
				hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
				// Build query
				query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
				query.append('=');
				query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
				if (itr.hasNext()) {
					query.append('&');
					hashData.append('&');
				}
			}
		}
		String queryUrl = query.toString();
		String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.toString());
		queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
		resp.sendRedirect(paymentUrl);
	}

}
