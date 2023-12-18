package DAO;

import java.util.List;

import Models.BillDetail;

public interface IBillDetailDAO {

	 List<BillDetail> findAll();
	    
	 void insert(BillDetail billDetail);
	    
	 void update(BillDetail billDetail);
	    
	 void delete(int billDetail_id);
	    
	 BillDetail findById(int billDetail_id);
	 
	 List<BillDetail> findBilDetailByBillID(int billID);
}
