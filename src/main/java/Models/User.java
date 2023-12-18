package Models;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userID;
	private String userName;
	private String password;
	private String email;
	private String code;
	private int role;
	private int status;
	
	public User() {
		super();
	}

	
	public User(int userID, String userName, String password, String email, String code, int role, int status) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.code = code;
		this.role = role;
		this.status = status;
	}

	

	public User(String userName, String password, String email, String code, int role, int status) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.code = code;
		this.role = role;
		this.status = status;
	}

	

	public User(String userName, String email, String code) {
		super();
		this.userName = userName;
		this.email = email;
		this.code = code;
	}


	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", code=" + code + ", role=" + role + "]";
	}
	
	
}
