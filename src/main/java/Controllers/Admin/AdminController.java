package Controllers.Admin;

import Models.Product;
import Services.ICartSerive;
import Services.IProductService;
import Services.IUserService;
import Services.Impl.CartService;
import Services.Impl.ProductService;
import Services.Impl.UserSerive;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/admin/home" })
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Views/admin/home.jsp").forward(req, resp);
    }
}




