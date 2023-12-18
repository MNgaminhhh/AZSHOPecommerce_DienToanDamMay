package DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connection.DBConnection;
import DAO.ISupplierDAO;
import Models.Supplier;

public class SupplierDAO implements ISupplierDAO{
	Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
	@Override
	public List<Supplier> findAll() {
		List<Supplier> listsupplier = new ArrayList<Supplier>();
        String query = "SELECT * FROM suppliers";
        try {
        	Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
            	Supplier supplier = new Supplier();
            	supplier.setSupplier_id(rs.getInt("supplier_id"));
            	supplier.setSupplier_name(rs.getString("supplier_name"));
            	listsupplier.add(supplier);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listsupplier;
	}

	@Override
	public void insert(Supplier supplier) {
		String query = "INSERT INTO suppliers(supplier_name) VALUES (?)";
        try {
        	Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, supplier.getSupplier_name());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void update(Supplier supplier) {
		String query = "UPDATE suppliers SET supplier_name = ? WHERE supplier_id = ? ";
        try {
        	Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
            ps.setString(1, supplier.getSupplier_name());
            ps.setInt(2, supplier.getSupplier_id());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public void delete(int supplier_id) {
		String query = "DELETE FROM suppliers WHERE supplier_id = ? ";
        try {
        	Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
            ps.setInt(1, supplier_id);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public Supplier findById(int supplier_id) {
		Supplier supplier = new Supplier();
        String query = "SELECT * FROM suppliers WHERE supplier_id = ? ";
        try {
        	Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
            ps.setInt(1, supplier_id);
            rs = ps.executeQuery();
            while (rs.next()) {
            	supplier.setSupplier_id(rs.getInt("supplier_id"));
            	supplier.setSupplier_name(rs.getString("supplier_name"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplier;
	}

	@Override
	public int countProduct(int supplier_id) {
		int result = 0;
        String query = "SELECT count(*) as count\r\n"
        		+ "FROM azshop.products\r\n"
        		+ "WHERE supplier_id = ?;";
        try {
        	Connection conn = new DBConnection().getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
            ps.setInt(1, supplier_id);
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
