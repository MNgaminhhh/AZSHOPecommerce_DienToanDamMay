package Controllers.Admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Bill;
import Models.BillDetail;
import Services.IBillDetailService;
import Services.Impl.BillDetailService;
import org.apache.commons.beanutils.BeanUtils;
import Services.IBillService;
import Services.Impl.BillService;
@WebServlet(urlPatterns = { "/admin/profit/profits", "/admin/profit/insert", "/admin/profit/update", "/admin/profit/delete"})
public class ProfitController extends HttpServlet{

    IBillDetailService profitService = new BillDetailService();
    IBillService billService = new BillService();

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().toString();
        if(url.contains("profits")) {
            findAll(req, resp);
        } else if(url.contains("insert")) {
            RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/profit/insert.jsp");
            rd.forward(req, resp);
        } else if(url.contains("update")) {
            int detailID = Integer.parseInt(req.getParameter("detailID"));
            BillDetail bill = profitService.findById(detailID);
            req.setAttribute("billDetail", bill);
            RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/profit/update.jsp");
            rd.forward(req, resp);
        } else if(url.contains("delete")) {
            Delete(req,resp);
        }
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            profitService.delete(Integer.parseInt(req.getParameter("detailID")));
            req.setAttribute("message", "Xoa thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Xoa that bai");
        }
        resp.sendRedirect(req.getContextPath()+"/admin/profit/profits");
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	List<Bill> bills = billService.findAll();
        req.setAttribute("bills", bills);
        
        List<BillDetail> billDetails = profitService.findAll();
        req.setAttribute("billDetails", billDetails);
        RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/profit/profits.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().toString();
        if(url.contains("insert")) {
            insert(req,resp);
        }else if(url.contains("update")) {
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BillDetail billDetail = new BillDetail();
        try {
            BeanUtils.populate(billDetail, req.getParameterMap());
            profitService.update(billDetail);
            req.setAttribute("message", "Chinh sua thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Chinh sua that bai");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/profit/profits");
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        BillDetail billDetail = new BillDetail();
        try {
            BeanUtils.populate(billDetail, req.getParameterMap());
            profitService.insert(billDetail);
            req.setAttribute("message", "Them thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Them that bai");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/profit/profits");
    }

}

