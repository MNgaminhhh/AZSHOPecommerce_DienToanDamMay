package Services.Impl;

import java.util.List;

import DAO.IProductDAO;
import DAO.Impl.ProductDAO;
import Models.Product;
import Services.IProductService;

public class ProductService implements IProductService {
	IProductDAO proDAO = new ProductDAO();

	@Override
	public List<Product> findAll() {
		return proDAO.findAll();
	}

	@Override
	public List<Product> findTop3(int offset) {
		return proDAO.findTop3(offset);
	}

	@Override
	public void Insert(Product product) {
		proDAO.Insert(product);
	}

	@Override
	public void Update(Product product) {
		proDAO.Update(product);
	}

	@Override
	public void Delete(int product_id) {
		proDAO.Delete(product_id);
	}

	@Override
	public Product findByID(int product_id) {
		return proDAO.findByID(product_id);
	}

	@Override
	public List<Product> findByName(String product_name) {
		return proDAO.findByName(product_name);
	}

	@Override
	public List<Product> findByCategory(int category_id) {
		return proDAO.findByCategory(category_id);
	}

	@Override
	public List<Product> findBySupplier(int supplier_id) {
		return proDAO.findBySupplier(supplier_id);
	}

	@Override
	public List<Product> findByPrice(float start_range, float end_range) {
		return proDAO.findByPrice(start_range, end_range);
	}

	@Override
	public List<Product> findTop3ByCategory(int category_id, int offset) {
		return proDAO.findTop3ByCategory(category_id, offset);
	}

	@Override
	public List<Product> findTop3BySupplier(int supplier_id, int offset) {
		return proDAO.findTop3BySupplier(supplier_id, offset);
	}

	@Override
	public List<Product> findTop3ByPrice(float start_range, float end_range, int offset) {
		return proDAO.findTop3ByPrice(start_range, end_range, offset);
	}

	@Override
	public List<Product> findBestSellingProdut() {
		return proDAO.findBestSellingProdut();
	}

	@Override
	public int countByCategory(int category_id) {
		return proDAO.countByCategory(category_id);
	}

	@Override
	public int countAllProduct() {
		return proDAO.countAllProduct();
	}
}
