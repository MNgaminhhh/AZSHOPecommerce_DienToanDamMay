package Models;

import java.io.Serializable;
import java.sql.Date;

public class ViewedProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	private int viewedID;
	private int userID;
	private int productID;
	private Date viewdate;
	public ViewedProduct() {
		super();
	}
	public ViewedProduct(int viewedID, int userID, int productID, Date viewdate) {
		super();
		this.viewedID = viewedID;
		this.userID = userID;
		this.productID = productID;
		this.viewdate = viewdate;
	}
	public int getViewedID() {
		return viewedID;
	}
	public void setViewedID(int viewedID) {
		this.viewedID = viewedID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public Date getViewdate() {
		return viewdate;
	}
	public void setViewdate(Date viewdate) {
		this.viewdate = viewdate;
	}
	@Override
	public String toString() {
		return "ViewedProduct [viewedID=" + viewedID + ", userID=" + userID + ", productID=" + productID + ", viewdate="
				+ viewdate + "]";
	}
	
	
}
