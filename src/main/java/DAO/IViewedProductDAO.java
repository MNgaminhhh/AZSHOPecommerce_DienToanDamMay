package DAO;

import java.util.List;

import Models.ViewedProduct;

public interface IViewedProductDAO {
	List<ViewedProduct> findAll();

	void insert(ViewedProduct viewedProduct);

	void update(ViewedProduct viewedProduct);

	void delete(int viewedProduct_id);

	ViewedProduct findById(int viewedProduct_id);
	
	List<ViewedProduct> findByUserId(int user_id);
	
	void CleanTable();
}
