package Models;

import java.io.Serializable;

public class Supplier implements Serializable{
	private static final long serialVersionUID = 1L;
	private int supplier_id;
	private String supplier_name;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Supplier() {
		super();
	}
	public Supplier(int supplier_id, String supplier_name) {
		super();
		this.supplier_id = supplier_id;
		this.supplier_name = supplier_name;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + "]";
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
}
