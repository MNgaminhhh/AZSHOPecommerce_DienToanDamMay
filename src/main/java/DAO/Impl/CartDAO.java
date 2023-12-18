package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ICartDAO;
import Models.Cart;
import Services.IProductService;
import Services.Impl.ProductService;

public class CartDAO implements ICartDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	IProductService proService = new ProductService();

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		List<Cart> listcart = new ArrayList<Cart>();
		String query = "SELECT * FROM carts";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setUser_id(rs.getInt("user_id"));
				cart.setProduct_id(rs.getInt("product_id"));
				cart.setQuantity(rs.getInt("quantity"));
				listcart.add(cart);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcart;
	}

	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO carts (user_id, product_id, quantity) VALUES (?, ?, ?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, cart.getUser_id());
			ps.setInt(2, cart.getProduct_id());
			ps.setInt(3, cart.getQuantity());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		String query = "UPDATE carts SET user_id = ?, product_id = ?, quantity = ? WHERE cart_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(4, cart.getCart_id());
			ps.setInt(1, cart.getUser_id());
			ps.setInt(2, cart.getProduct_id());
			ps.setInt(3, cart.getQuantity());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int cart_id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM carts WHERE cart_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, cart_id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Cart findById(int cart_id) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		String query = "SELECT * FROM carts WHERE cart_id = ? ";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, cart_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setUser_id(rs.getInt("user_id"));
				cart.setProduct_id(rs.getInt("product_id"));
				cart.setQuantity(rs.getInt("quantity"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public List<Cart> findByUserID(int user_id) {
		// TODO Auto-generated method stub
		List<Cart> listcart = new ArrayList<Cart>();
		String query = "SELECT * FROM carts WHERE carts.user_id = ?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setUser_id(rs.getInt("user_id"));
				cart.setProduct_id(rs.getInt("product_id"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setProduct(proService.findByID(cart.getProduct_id()));
				cart.setTotal_price(cart.getQuantity() * cart.getProduct().getPrice());
				listcart.add(cart);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcart;
	}

	@Override
	public Cart findByUserIdAndProductID(int user_id, int product_id) {
		Cart cart = new Cart();
		String query = "SELECT * FROM carts WHERE carts.user_id = ? and carts.product_id = ?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, user_id);
			ps.setInt(2, product_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cart.setCart_id(rs.getInt("cart_id"));
				cart.setUser_id(rs.getInt("user_id"));
				cart.setProduct_id(rs.getInt("product_id"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setProduct(proService.findByID(cart.getProduct_id()));
				cart.setTotal_price(cart.getQuantity() * cart.getProduct().getPrice());
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

}
