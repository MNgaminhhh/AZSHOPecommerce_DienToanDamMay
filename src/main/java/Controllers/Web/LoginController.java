package Controllers.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Models.User;
import Services.IUserService;
import Services.Impl.UserSerive;
import Utils.Constant;
import Utils.Email;

@WebServlet(urlPatterns = { "/user/login", "/user/logout", "/user/register", "/user/forgotpass", "/user/waiting",
		"/user/VerifyCode", "/user/changepass"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -3189424333469822611L;

	IUserService userService = new UserSerive();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();

		if (url.contains("register")) {
			getRegister(req, resp);
		} else if (url.contains("login")) {
			getLogin(req, resp);
		} else if (url.contains("forgotpass")) {
			req.getRequestDispatcher("/Views/user/forgotpass.jsp").forward(req, resp);
		} else if (url.contains("waiting")) {
			getWaiting(req, resp);
		} else if (url.contains("VerifyCode")) {
			req.getRequestDispatcher("/Views/user/verify.jsp").forward(req, resp);
		} else if (url.contains("logout")) {
			getlogout(req, resp);
		} else if (url.contains("changepass")) {
			req.getRequestDispatcher("/Views/user/changepass.jsp").forward(req, resp);
		} else {
			homePage(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("register")) {
			postRegister(req, resp);
		} else if (url.contains("login")) {
			postLogin(req, resp);
		} else if (url.contains("forgotpass")) {
			postForgotPass(req, resp);
		} else if (url.contains("VerifyCode")) {
			postVerifyCode(req, resp);
		} else if (url.contains("changepass")) {
			changepass(req, resp);
		}
	}

	private void homePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/web/home.jsp").forward(req, resp);
	}

	private void getRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/user/register.jsp").forward(req, resp);
	}

	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		String alertMsg = "";
		if (userService.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/Views/user/register.jsp").forward(req, resp);
		} else if (userService.checkExistEmail(username)) {
			alertMsg = "Tài khoản đã tồn tại";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/Views/user/register.jsp").forward(req, resp);
		} else {
			Email sm = new Email();
			String code = sm.getRandom();
			User user = new User(username, email, code);
			boolean test = sm.sendEmail(user);

			if (test) {
				HttpSession session = req.getSession();
				session.setAttribute("account", user);
				boolean isSuccess = userService.register(email, password, username, code);

				if (isSuccess) {
					resp.sendRedirect(req.getContextPath() + "/user/VerifyCode");
				} else {
					alertMsg = "Lỗi hệ thống!!!";
					req.setAttribute("error", alertMsg);
					req.getRequestDispatcher("/Views/user/register.jsp").forward(req, resp);
				}

			} else {
				PrintWriter out = resp.getWriter();
				out.println("Lỗi khi gửi mail!!!!!");
			}
		}
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/user/waiting");
			return;
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/user/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/Views/user/login.jsp").forward(req, resp);
	}

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("message", alertMsg);
			req.getRequestDispatcher("/Views/user/login.jsp").forward(req, resp);
			return;
		}

		User user = userService.login(username, password);

		if (user != null) {
			if (user.getStatus() == 1) {
				HttpSession session = req.getSession();
				session.setAttribute("account", user);

				if (isRememberMe) {
					saveRememberMe(resp, username);
				}
				resp.sendRedirect(req.getContextPath() + "/user/waiting");

			} else {
				alertMsg = "Tài khoản đã bị khóa, liên hệ admin";
				req.setAttribute("message", alertMsg);
				req.getRequestDispatcher("/Views/user/login.jsp").forward(req, resp);
			}
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("message", alertMsg);
			req.getRequestDispatcher("/Views/user/login.jsp").forward(req, resp);
		}
	}

	private void saveRememberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		resp.addCookie(cookie);
		;
	}

	private void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			req.setAttribute("username", u.getUserName());
			if (u.getRole() == 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else if (u.getRole() == 1) {
				resp.sendRedirect(req.getContextPath() + "/manager/home");
			} else if (u.getRole() == 2) {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/user/login");
		}

	}

	private void postVerifyCode(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("account");

			String code = req.getParameter("authcode");

			if (code.equals(u.getCode())) {
				u.setEmail(u.getEmail());
				u.setStatus(1);

				userService.updatestatus(u);

				out.println("<div class=\"container\"><br/>\r\n" + "  <br/>\r\n"
						+ "<br/>Kích hoạt tài khoản thành công!<br/>\r\n" + "  <br/>\r\n" + "<br/></div>");
			} else {
				out.println("<div class=\"container\"><br/>\r\n" + "  <br/>\r\n"
						+ "<br/>Sai mã kích hoạt vui lòng kiểm tra lại!<br/>\r\n" + "  <br/>\r\n" + "<br/></div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void postForgotPass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		User user = userService.findByUserName(username);

		if (user.getEmail().equals(email) && user.getUserName().equals(username)) {
			Email sm = new Email();
			boolean test = sm.EmailSend(user);
			if (test) {
				req.setAttribute("message", "Vui lòng kiểm tra email để nhận mật khẩu");
			} else {
				req.setAttribute("error", "Lỗi gửi email!!!");
			}
		} else {
			req.setAttribute("error", "Username hoặc email không chính xác!!!");
			req.getRequestDispatcher("/Views/user/forgotpass.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/Views/user/forgotpass.jsp").forward(req, resp);
	}

	private void getlogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("account");
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					break;
				}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/home");

	}

	private void changepass(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("account");

			String oldpass = req.getParameter("oldpass");
			String newpass = req.getParameter("newpass");

			if (oldpass.equals(u.getPassword())) {
				u.setPassword(newpass);
				userService.update(u);
				
				out.println("<div class=\"container\"><br/>\r\n" + "  <br/>\r\n"
						+ "<br/>Đổi mật khẩu thành công!<br/>\r\n" + "  <br/>\r\n" + "<br/></div>");
			} else {
				out.println("<div class=\"container\"><br/>\r\n" + "  <br/>\r\n"
						+ "<br/>Đổi mật khẩu thất bại!<br/>\r\n" + "  <br/>\r\n" + "<br/></div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
