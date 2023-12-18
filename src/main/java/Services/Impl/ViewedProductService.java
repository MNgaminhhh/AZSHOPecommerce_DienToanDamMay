package Services.Impl;

import java.util.List;

import DAO.IViewedProductDAO;
import DAO.Impl.ViewedProductDAO;
import Models.ViewedProduct;
import Services.IViewedProductService;

public class ViewedProductService implements IViewedProductService {

	IViewedProductDAO vpDAO = new ViewedProductDAO();
	
	@Override
	public List<ViewedProduct> findAll() {
		return vpDAO.findAll();
	}

	@Override
	public void insert(ViewedProduct viewedProduct) {
		vpDAO.insert(viewedProduct);
		
	}

	@Override
	public void update(ViewedProduct viewedProduct) {
		ViewedProduct oldvp = vpDAO.findById(viewedProduct.getViewedID());
		oldvp.setViewedID(viewedProduct.getViewedID());
		oldvp.setUserID(viewedProduct.getUserID());
		oldvp.setProductID(viewedProduct.getProductID());
		oldvp.setViewdate(viewedProduct.getViewdate());
		
		vpDAO.update(oldvp);
	}

	@Override
	public void delete(int viewedProduct_id) {
		vpDAO.delete(viewedProduct_id);
		
	}

	@Override
	public ViewedProduct findById(int viewedProduct_id) {
		return vpDAO.findById(viewedProduct_id);
	}

	@Override
	public List<ViewedProduct> findByUserId(int user_id) {
		return vpDAO.findByUserId(user_id);
	}

	@Override
	public void CleanTable() {
		vpDAO.CleanTable();
	}

}
