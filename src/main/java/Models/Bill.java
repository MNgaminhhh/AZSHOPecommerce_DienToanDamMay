package Models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Bill implements Serializable {

	private static final long serialVersionUID = 1L;
	private int bill_id;
	private int user_id;
	private Date order_date;
	private BigDecimal total_amount;
	String receiver;
	String phone;
	String address;
	
	public Bill(int bill_id, int user_id, Date order_date, BigDecimal total_amount, String receiver, String phone,
			String address) {
		super();
		this.bill_id = bill_id;
		this.user_id = user_id;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.receiver = receiver;
		this.phone = phone;
		this.address = address;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public BigDecimal getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}
	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", user_id=" + user_id + ", order_date=" + order_date + ", total_amount="
				+ total_amount + ", receiver=" + receiver + ", phone=" + phone + ", address=" + address + "]";
	}
	
}
