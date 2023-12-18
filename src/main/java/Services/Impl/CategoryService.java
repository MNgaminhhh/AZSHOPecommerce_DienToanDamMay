package Services.Impl;

import java.util.List;
import DAO.ICategoryDAO;
import DAO.Impl.CategoryDAO;
import Models.Category;
import Services.ICategoryService;

public class CategoryService implements ICategoryService{

	ICategoryDAO cateDAO = new CategoryDAO();
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDAO.findAll();
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		cateDAO.insert(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		cateDAO.update(category);
	}

	@Override
	public void delete(int category_id) {
		// TODO Auto-generated method stub
		cateDAO.delete(category_id);
	}

	@Override
	public Category findById(int category_id) {
		// TODO Auto-generated method stub
		return cateDAO.findById(category_id);
	}

	@Override
	public int countProduct(int category_id) {
		// TODO Auto-generated method stub
		return cateDAO.countProduct(category_id);
	}

}
