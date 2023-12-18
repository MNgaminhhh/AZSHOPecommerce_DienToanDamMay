package Controllers.Admin;

import java.io.IOException;

import Services.Impl.BillService;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.IBillService;
import Models.Bill;
import Models.BillDetail;
import Services.IBillDetailService;

import Services.Impl.BillDetailService;


import Models.Product;
import Services.IProductService;
import Services.Impl.ProductService;

@WebServlet(urlPatterns = { "/admin/statistic/statistic" })
public class StatisticController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductService proService = new ProductService();
    IBillDetailService billDetailService = new BillDetailService();
    IBillService billService = new BillService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().toString();
        if (url.contains("admin/statistic/statistic")) {
            getList(req, resp);
        }
    }
    protected void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = proService.findAll();
        req.setAttribute("products", products);
        
        List<Bill> bills = billService.findAll();
        req.setAttribute("bills", bills);

        
        List<BillDetail> billDetails = billDetailService.findAll();
        req.setAttribute("billDetails", billDetails);

        req.getRequestDispatcher("/Views/admin/statistic/statistic.jsp").forward(req, resp);
    }

}
