package DAO;

import java.util.List;

import Models.Product;

public interface IProductDAO {
	List<Product> findAll();
	void Insert(Product product);
	void Update(Product product);
	void Delete(int product_id);
	Product findByID(int product_id);
	List<Product> findByName(String product_name);
	List<Product> findByCategory(int category_id);
	List<Product> findBySupplier(int supplier_id);
	List<Product> findByPrice(float start_range, float end_range);
	List<Product> findTop3(int offset);
	List<Product> findTop3ByCategory(int category_id, int offset);
	List<Product> findTop3BySupplier(int supplier_id, int offset);
	List<Product> findTop3ByPrice(float start_range, float end_range, int offset);
	List<Product> findBestSellingProdut();
	

	int countByCategory(int category_id);
	int countAllProduct();	
}
