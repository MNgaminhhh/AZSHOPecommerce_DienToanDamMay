package Models;

import java.io.Serializable;
import java.math.BigDecimal;

public class BillDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	private int detailID;
	private int billID;
	private int productID;
	private int quantity;
	private BigDecimal price;
	private Product product;
	public BillDetail() {
		super();
	}
	
	public BillDetail(int detailID, int billID, int productID, int quantity, BigDecimal price) {
		super();
		this.detailID = detailID;
		this.billID = billID;
		this.productID = productID;
		this.quantity = quantity;
		this.price = price;
	}

	public int getDetailID() {
		return detailID;
	}
	public void setDetailID(int detailID) {
		this.detailID = detailID;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "BillDetail [detailID=" + detailID + ", billID=" + billID + ", productID=" + productID + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
}
