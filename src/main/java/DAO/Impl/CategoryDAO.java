package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ICategoryDAO;
import Models.Category;

public class CategoryDAO implements ICategoryDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public List<Category> findAll() {
		List<Category> listcate = new ArrayList<Category>();
		String query = "SELECT * FROM categories";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCategory_id(rs.getInt("category_id"));
				category.setCategory_name(rs.getString("category_name"));
				listcate.add(category);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcate;
	}

	@Override
	public void insert(Category category) {
		String query = "INSERT INTO categories(category_id, category_name) VALUES (?, ?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, category.getCategory_id());
			ps.setString(2, category.getCategory_name());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Category category) {
		String query = "UPDATE categories SET category_name = ? WHERE category_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(2, category.getCategory_id());
			ps.setString(1, category.getCategory_name());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int category_id) {
		String query = "DELETE FROM categories WHERE category_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, category_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category findById(int category_id) {
		Category category = new Category();
		String query = "SELECT * FROM categories WHERE category_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, category_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setCategory_id(rs.getInt("category_id"));
				category.setCategory_name(rs.getString("category_name"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public int countProduct(int category_id) {
		int result = 0;
		String query = "SELECT count(*) as count\r\n" + "FROM azshop.products\r\n" + "WHERE category_id = ?;";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, category_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt("count");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
