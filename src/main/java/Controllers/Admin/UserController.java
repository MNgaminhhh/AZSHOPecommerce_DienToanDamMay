package Controllers.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.User;
import Services.IUserService;
import Services.Impl.UserSerive;
import org.apache.commons.beanutils.BeanUtils;


@WebServlet(urlPatterns = { "/admin/user/list", "/admin/user/insert", "/admin/user/update", "/admin/user/delete" })
public class UserController extends HttpServlet{

    IUserService userService = new UserSerive();

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI().toString();
        if(url.contains("list")) {
            findAll(req, resp);
        }
        else if(url.contains("insert")) {
            RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/user/insert.jsp");
            rd.forward(req, resp);
        }
        else if(url.contains("update")) {
            int user_id = Integer.parseInt(req.getParameter("userID"));
            User user = userService.findOne(user_id);
            req.setAttribute("user", user);
            RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/user/update.jsp");
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
            userService.delete(Integer.parseInt(req.getParameter("userID")));
            req.setAttribute("message", "Xoa thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Xoa that bai");
        }
        resp.sendRedirect(req.getContextPath()+"/admin/user/list");
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<User> users = userService.findAll();
        req.setAttribute("users", users);
        RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/user/list.jsp");
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

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        User user = new User();
        //req.setAttribute("user", user);
        try {
            BeanUtils.populate(user, req.getParameterMap());
            userService.update(user);
            req.setAttribute("message", "Chinh sua thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Chinh sua that bai");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/user/list");
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
            userService.insert(user);
            req.setAttribute("message", "Them thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Them that bai");
        }
        resp.sendRedirect(req.getContextPath() + "/admin/user/list");
    }

}

