package Controllers.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Models.Category;
import Services.ICategoryService;
import Services.Impl.CategoryService;

@WebServlet(urlPatterns = { "/admin/category/list", "/admin/category/insert", "/admin/category/update", "/admin/category/delete" })
public class CategoryController extends HttpServlet{
	
	ICategoryService CategoryService = new CategoryService();
			
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if(url.contains("list")) {
			findAll(req, resp);
		}
		else if(url.contains("insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/category/insert.jsp");
			rd.forward(req, resp);
		}
		else if(url.contains("update")) {
			int category_id = Integer.parseInt(req.getParameter("category_id"));
			Category category = CategoryService.findById(category_id);
			req.setAttribute("category", category);
			RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/category/update.jsp");
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
			CategoryService.delete(Integer.parseInt(req.getParameter("category_id")));
			req.setAttribute("message", "Xoa thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Xoa that bai");
		}
		resp.sendRedirect(req.getContextPath()+"/admin/category/list");
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> listcate = CategoryService.findAll();
		req.setAttribute("listcate", listcate);
		RequestDispatcher rd = req.getRequestDispatcher("/Views/admin/category/list.jsp");
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
		Category cate = new Category();
		try {
			BeanUtils.populate(cate, req.getParameterMap());
			CategoryService.update(cate);
			req.setAttribute("message", "Chinh sua thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Chinh sua that bai");
		}
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}


	private void insert(HttpServletRequest req, HttpServletResponse resp)throws ServletException ,IOException{
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Category cate = new Category();
		try {
			BeanUtils.populate(cate, req.getParameterMap());
			CategoryService.insert(cate);
			req.setAttribute("message", "Them thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Them that bai");
		}
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}	
	
}

