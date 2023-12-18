package Services;

import java.util.List;

import Models.Supplier;

public interface ISupplierService {
	List<Supplier> findAll();
    
	 void insert(Supplier supplier);
	    
	 void update(Supplier supplier);
	    
	 void delete(int supplier_id);
	    
	 Supplier findById(int supplier_id);
	 
	 int countProduct(int supllier_id);
}
