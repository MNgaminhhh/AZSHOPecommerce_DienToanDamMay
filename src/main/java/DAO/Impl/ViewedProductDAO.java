package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IViewedProductDAO;
import Models.ViewedProduct;

public class ViewedProductDAO implements IViewedProductDAO{

	@Override
	public List<ViewedProduct> findAll() {
		List<ViewedProduct> listvp = new ArrayList<ViewedProduct>();
		String sql = "Select * from viewed_products";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ViewedProduct model = new ViewedProduct();
				model.setViewedID(rs.getInt("viewed_id"));
				model.setUserID(rs.getInt("user_id"));
				model.setProductID(rs.getInt("product_id"));
				model.setViewdate(rs.getDate("view_date"));
				listvp.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listvp;
	}

	@Override
	public void insert(ViewedProduct viewedProduct) {
		String sql = "Insert into viewed_products(user_id, product_id, view_date) values(?, ?, ?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewedProduct.getUserID());
			ps.setInt(2, viewedProduct.getProductID());
			ps.setDate(3, viewedProduct.getViewdate());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(ViewedProduct viewedProduct) {
		String sql = "Update viewed_products set user_id=?, product_id=?, view_date=? where viewed_id=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewedProduct.getUserID());
			ps.setInt(2, viewedProduct.getProductID());
			ps.setDate(3, viewedProduct.getViewdate());
			ps.setInt(4, viewedProduct.getViewedID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int viewedProduct_id) {
		String sql = "delete from viewed_products where viewed_id = ?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewedProduct_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ViewedProduct findById(int viewedProduct_id) {
		String sql = "Select * from viewed_products where viewed_id = ?";
		ViewedProduct model = new ViewedProduct();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, viewedProduct_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				model.setViewedID(rs.getInt("viewed_id"));
				model.setUserID(rs.getInt("user_id"));
				model.setProductID(rs.getInt("product_id"));
				model.setViewdate(rs.getDate("view_date"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}

	@Override
	public List<ViewedProduct> findByUserId(int user_id) {
		String sql = "Select * from viewed_products where user_id = ? LIMIT 12";
		List<ViewedProduct> lists = new ArrayList<ViewedProduct>();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ViewedProduct model = new ViewedProduct();
				model.setViewedID(rs.getInt("viewed_id"));
				model.setUserID(rs.getInt("user_id"));
				model.setProductID(rs.getInt("product_id"));
				model.setViewdate(rs.getDate("view_date"));
				lists.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lists;
	}

	@Override
	public void CleanTable() {
		String sql = "delete from viewed_products where user_id = 0";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
