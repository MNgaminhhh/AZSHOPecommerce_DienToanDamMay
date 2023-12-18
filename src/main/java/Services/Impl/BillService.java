package Services.Impl;

import java.util.List;

import DAO.IBillDAO;
import DAO.Impl.BillDAO;
import Models.Bill;
import Services.IBillService;

public class BillService implements IBillService{
	IBillDAO billDAO = new BillDAO();

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		return billDAO.findAll();
	}

	@Override
	public void insert(Bill bill) {
		// TODO Auto-generated method stub
		billDAO.insert(bill);
	}

	@Override
	public void update(Bill bill) {
		// TODO Auto-generated method stub
		billDAO.update(bill);
	}

	@Override
	public void delete(int bill_id) {
		// TODO Auto-generated method stub
		billDAO.delete(bill_id);
	}

	@Override
	public Bill findById(int bill_id) {
		// TODO Auto-generated method stub
		return billDAO.findById(bill_id);
	}

	@Override
	public Bill findNewestBillByUserID(int user_id) {
		return billDAO.findNewestBillByUserID(user_id);
	}

	@Override
	public List<Bill> findByUserID(int userid) {
		// TODO Auto-generated method stub
		return billDAO.findByUserID(userid);
	}

	
	
	
}
