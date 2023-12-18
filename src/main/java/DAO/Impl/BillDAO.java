package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IBillDAO;

import Models.Bill;

public class BillDAO implements IBillDAO {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		List<Bill> listbill = new ArrayList<Bill>();
		String query = "SELECT * FROM bills";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setBill_id(rs.getInt("bill_id"));
				bill.setUser_id(rs.getInt("user_id"));
				bill.setOrder_date(rs.getDate("order_date"));
				bill.setTotal_amount(rs.getBigDecimal("total_amount"));
				bill.setReceiver(rs.getString("receiver"));
				bill.setPhone(rs.getString("phone"));
				bill.setAddress(rs.getString("address"));

				listbill.add(bill);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbill;
	}

	@Override
	public void insert(Bill bill) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO bills(user_id, order_date, total_amount, receiver, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, bill.getUser_id());
			ps.setDate(2, bill.getOrder_date());
			ps.setBigDecimal(3, bill.getTotal_amount());
			ps.setString(4, bill.getReceiver());
			ps.setString(5, bill.getPhone());
			ps.setString(6, bill.getAddress());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Bill bill) {
		// TODO Auto-generated method stub
		String query = "UPDATE bills SET user_id = ?,order_date = ?,total_amount = ?,receiver = ?, phone = ?, address = ?, WHERE bill_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, bill.getUser_id());
			ps.setDate(2, bill.getOrder_date());
			ps.setBigDecimal(3, bill.getTotal_amount());
			ps.setString(4, bill.getReceiver());
			ps.setString(5, bill.getPhone());
			ps.setString(6, bill.getAddress());
			ps.setInt(7, bill.getBill_id());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int bill_id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM bills WHERE bill_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, bill_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Bill findById(int bill_id) {
		// TODO Auto-generated method stub
		Bill bill = new Bill();
		String query = "SELECT * FROM bills WHERE bill_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, bill_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				bill.setBill_id(rs.getInt("bill_id"));
				bill.setUser_id(rs.getInt("user_id"));
				bill.setOrder_date(rs.getDate("order_date"));
				bill.setTotal_amount(rs.getBigDecimal("total_amount"));
				bill.setReceiver(rs.getString("receiver"));
				bill.setPhone(rs.getString("phone"));
				bill.setAddress(rs.getString("address"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bill;

	}

	@Override
	public Bill findNewestBillByUserID(int user_id) {
		// TODO Auto-generated method stub
		Bill bill = new Bill();
		String query = "SELECT * FROM bills\r\n" + "WHERE user_id = ? \r\n" + "ORDER BY bill_id DESC\r\n"
				+ "LIMIT 1;\r\n" + "";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				bill.setBill_id(rs.getInt("bill_id"));
				bill.setUser_id(rs.getInt("user_id"));
				bill.setOrder_date(rs.getDate("order_date"));
				bill.setTotal_amount(rs.getBigDecimal("total_amount"));
				bill.setReceiver(rs.getString("receiver"));
				bill.setPhone(rs.getString("phone"));
				bill.setAddress(rs.getString("address"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bill;
	}

	@Override
	public List<Bill> findByUserID(int userid) {
		List<Bill> listbill = new ArrayList<Bill>();
		String query = "SELECT * FROM bills\r\n" + "WHERE user_id = ? \r\n" ;
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setBill_id(rs.getInt("bill_id"));
				bill.setUser_id(rs.getInt("user_id"));
				bill.setOrder_date(rs.getDate("order_date"));
				bill.setTotal_amount(rs.getBigDecimal("total_amount"));
				bill.setReceiver(rs.getString("receiver"));
				bill.setPhone(rs.getString("phone"));
				bill.setAddress(rs.getString("address"));

				listbill.add(bill);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listbill;
	}

}
