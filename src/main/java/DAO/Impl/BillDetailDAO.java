package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IBillDetailDAO;
import Models.BillDetail;

public class BillDetailDAO implements IBillDetailDAO{

	@Override
	public List<BillDetail> findAll() {
		List<BillDetail> listbilldetail = new ArrayList<BillDetail>();
		String sql = "select * from bill_details";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BillDetail model = new BillDetail();
				model.setDetailID(rs.getInt("detail_id"));
				model.setBillID(rs.getInt("bill_id"));
				model.setProductID(rs.getInt("product_id"));
				model.setQuantity(rs.getInt("quantity"));
				model.setPrice(rs.getBigDecimal("price"));
				listbilldetail.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbilldetail;
	}

	@Override
	public void insert(BillDetail billDetail) {
		String sql = "Insert into bill_details(bill_id, product_id, quantity, price) values(?, ?, ?, ?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, billDetail.getBillID());
			ps.setInt(2, billDetail.getProductID());
			ps.setInt(3, billDetail.getQuantity());
			ps.setBigDecimal(4, billDetail.getPrice());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void update(BillDetail billDetail) {
		String sql = "Update bill_details set bill_id=?, product_id=?, quantity=?, price=? where detail_id=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, billDetail.getBillID());
			ps.setInt(2, billDetail.getProductID());
			ps.setInt(3, billDetail.getQuantity());
			ps.setBigDecimal(4, billDetail.getPrice());
			ps.setInt(5, billDetail.getDetailID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int billDetail_id) {
		String sql = "delete from bill_details where detail_id = ?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, billDetail_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public BillDetail findById(int billDetail_id) {
		String sql = "Select * from bill_details where detail_id=?";
		BillDetail model = new BillDetail();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, billDetail_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				model.setDetailID(rs.getInt("detail_id"));
				model.setBillID(rs.getInt("bill_id"));
				model.setProductID(rs.getInt("product_id"));
				model.setQuantity(rs.getInt("quantity"));
				model.setPrice(rs.getBigDecimal("price"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public List<BillDetail> findBilDetailByBillID(int billID) {
		List<BillDetail> listbilldetail = new ArrayList<BillDetail>();
		String sql = "select * from bill_details where bill_id=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, billID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BillDetail model = new BillDetail();
				model.setDetailID(rs.getInt("detail_id"));
				model.setBillID(rs.getInt("bill_id"));
				model.setProductID(rs.getInt("product_id"));
				model.setQuantity(rs.getInt("quantity"));
				model.setPrice(rs.getBigDecimal("price"));
				listbilldetail.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbilldetail;
	}

}
