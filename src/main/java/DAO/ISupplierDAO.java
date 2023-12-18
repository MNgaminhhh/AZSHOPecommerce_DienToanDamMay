package DAO;

import java.util.List;

import Models.Supplier;

public interface ISupplierDAO {

	List<Supplier> findAll();

	void insert(Supplier supplier);

	void update(Supplier supplier);

	void delete(int supplier_id);

	Supplier findById(int supplier_id);
	
	int countProduct(int supplier_id);
}
