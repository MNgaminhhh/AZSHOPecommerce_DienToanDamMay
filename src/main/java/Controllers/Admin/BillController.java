package Controllers.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Bill;
import Services.IBillService;
import Services.Impl.BillService;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = { "/admin/bill/list", "/admin/bill/insert", "/admin/bill/update", "/admin/bill/delete" })
public class BillController extends HttpServlet{

    IBillService billService = new BillService();

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().toString();
        if(url.contains("list")) {
            findAll(req, resp);
        } else if(url.contains("insert")) {
            RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/bill/insert.jsp");
            rd.forward(req, resp);
        } else if(url.contains("update")) {
            int bill_id = Integer.parseInt(req.getParameter("bill_id"));
            Bill bill = billService.findById(bill_id);
            req.setAttribute("bill", bill);
            RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/bill/update.jsp");
            rd.forward(req, resp);
        }
        else if(url.contains("delete"))
        {
            Delete(req,resp);
        }
    }

    private void Delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            billService.delete(Integer.parseInt(req.getParameter("bill_id")));
            req.setAttribute("message", "Xoa thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Xoa that bai");
        }
        resp.sendRedirect(req.getContextPath()+"/admin/bill/list");
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Bill> bills = billService.findAll();
        req.setAttribute("bills", bills);
        RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/bill/list.jsp");
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
        Bill bill = new Bill();
        try {
            BeanUtils.populate(bill, req.getParameterMap());
            billService.update(bill);
            req.setAttribute("message", "Chinh sua thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Chinh sua that bai");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/bill/list");
    }


    private void insert(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        Bill bill = new Bill();
        try {
            BeanUtils.populate(bill, req.getParameterMap());
            billService.insert(bill);
            req.setAttribute("message", "Them thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Them that bai");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/bill/list");
    }

}

