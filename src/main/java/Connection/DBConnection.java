package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	// Thông tin kết nối
	private final String serverName = "dataazshop.cs57ksedv8l0.ap-southeast-1.rds.amazonaws.com";
	private final String portNumber = "3306";
	private final String dbName = "AZSHOP";
	String userID = "root";
	String password = "Minhng2003";

	public Connection getConnection() throws Exception {

		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try (Connection conn = new DBConnection().getConnection()) {
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			System.err.println("Lỗi kết nối đến cơ sở dữ liệu!");
			e.printStackTrace();
		}
	}
}