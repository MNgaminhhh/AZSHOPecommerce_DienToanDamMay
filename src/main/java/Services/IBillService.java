package Services;

import java.util.List;

import Models.Bill;
import Models.BillDetail;

public interface IBillService {

	 List<Bill> findAll();
	    
	 void insert(Bill bill);
	    
	 void update(Bill bill);
	    
	 void delete(int bill_id);
	    
	 Bill findById(int bill_id);
	 
	 List<Bill> findByUserID(int userid);
	 
	 Bill findNewestBillByUserID(int user_id);
}
