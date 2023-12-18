package Services.Impl;

import java.util.List;

import DAO.ISupplierDAO;
import DAO.Impl.SupplierDAO;
import Models.Supplier;
import Services.ISupplierService;

public class SupplierService implements ISupplierService{
	ISupplierDAO supDAO = new SupplierDAO();
	
	@Override
	public List<Supplier> findAll() {
		return supDAO.findAll();
	}

	@Override
	public void insert(Supplier supplier) {
		supDAO.insert(supplier);
	}

	@Override
	public void update(Supplier supplier) {
		supDAO.update(supplier);
	}

	@Override
	public void delete(int supplier_id) {
		supDAO.delete(supplier_id);
	}

	@Override
	public Supplier findById(int supplier_id) {
		return supDAO.findById(supplier_id);
	}

	@Override
	public int countProduct(int supplier_id) {
		return supDAO.countProduct(supplier_id);
	}

}
