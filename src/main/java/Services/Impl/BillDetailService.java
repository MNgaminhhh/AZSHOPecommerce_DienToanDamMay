package Services.Impl;

import java.util.List;

import DAO.IBillDetailDAO;
import DAO.Impl.BillDetailDAO;
import Models.BillDetail;
import Services.IBillDetailService;

public class BillDetailService implements IBillDetailService {

	IBillDetailDAO bdDAO = new BillDetailDAO();
	
	@Override
	public List<BillDetail> findAll() {
		return bdDAO.findAll();
	}

	@Override
	public void insert(BillDetail billDetail) {
		bdDAO.insert(billDetail);
	}

	@Override
	public void update(BillDetail billDetail) {
		BillDetail oldmodel = bdDAO.findById(billDetail.getDetailID());
		oldmodel.setDetailID(billDetail.getDetailID());
		oldmodel.setBillID(billDetail.getBillID());
		oldmodel.setProductID(billDetail.getProductID());
		oldmodel.setQuantity(billDetail.getQuantity());
		oldmodel.setPrice(billDetail.getPrice());
		
		bdDAO.update(oldmodel);
	}

	@Override
	public void delete(int billDetail_id) {
		bdDAO.delete(billDetail_id);
		
	}

	@Override
	public BillDetail findById(int billDetail_id) {
		return bdDAO.findById(billDetail_id);
	}

	@Override
	public List<BillDetail> findBilDetailByBillID(int billID) {
		return bdDAO.findBilDetailByBillID(billID);
	}

}
