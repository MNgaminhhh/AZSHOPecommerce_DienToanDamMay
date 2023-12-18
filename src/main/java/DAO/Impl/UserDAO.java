package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.IUserDAO;
import Models.User;

public class UserDAO implements IUserDAO {

	@Override
	public List<User> findAll() {
		List<User> listuser = new ArrayList<User>();
		String sql = "select * from users";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User model = new User();
				model.setUserID(rs.getInt("user_id"));
				model.setUserName(rs.getString("username"));
				model.setPassword(rs.getString("password"));
				model.setEmail(rs.getString("email"));
				model.setCode(rs.getString("code"));
				model.setRole(rs.getInt("role"));
				model.setStatus(rs.getInt("status"));
				listuser.add(model);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listuser;
	}

	@Override
	public void insert(User model) {
		String sql = "Insert into users(username, password, email, role, status) values(?, ?, ?, ?, ?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, model.getUserName());
			ps.setString(2, model.getPassword());
			ps.setString(3, model.getEmail());
			ps.setInt(4, model.getRole());
			ps.setInt(5, model.getStatus());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findOne(int id) {
		String sql = "select * from users where user_id = ?";
		User model = new User();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setUserID(rs.getInt("user_id"));
				model.setUserName(rs.getString("username"));
				model.setPassword(rs.getString("password"));
				model.setEmail(rs.getString("email"));
				model.setCode(rs.getString("code"));
				model.setRole(rs.getInt("role"));
				model.setStatus(rs.getInt("status"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public void update(User model) {
		String sql = "update users set username=?, password=?, email=?, role=?, status=? where user_id=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, model.getUserName());
			ps.setString(2, model.getPassword());
			ps.setString(3, model.getEmail());
			ps.setInt(4, model.getRole());
			ps.setInt(5, model.getStatus());
			ps.setInt(6, model.getUserID());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "delete from users where user_id = ?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void insertregister(User user) {
		String sql = "Insert into users(username, password, email, code, role, status) values(?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getCode());
			ps.setInt(5, user.getRole());
			ps.setInt(6, user.getStatus());

			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean dup = false;
		String sql = "Select * from users where email=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dup = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dup;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean dup = false;
		String sql = "Select * from users where username=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ps.setString(1, username);
			if (rs.next()) {
				dup = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dup;
	}

	@Override
	public void updatestatus(User user) {
		String sql = "Update users set status=? where email=?";
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, user.getStatus());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public User findByUserName(String username) {
		String sql = "select * from users where username = ?";
		User model = new User();
		try {
			Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				model.setUserID(rs.getInt("user_id"));
				model.setUserName(rs.getString("username"));
				model.setPassword(rs.getString("password"));
				model.setEmail(rs.getString("email"));
				model.setCode(rs.getString("code"));
				model.setRole(rs.getInt("role"));
				model.setStatus(rs.getInt("status"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
