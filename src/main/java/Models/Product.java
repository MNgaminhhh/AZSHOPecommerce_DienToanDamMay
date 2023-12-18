package Models;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private int product_id;
	private String product_name;
	private String description;
	private float price;
	private int category_id;
	private int supplier_id;
	private String image;
	private String images;
	private int stock_quantity;
	private int sold_quantity;

	public Product() {
		super();
	}

	public Product(int product_id, String product_name, String description, float price,
			int category_id, int supplier_id, String image, String images, int stock_quantity, int sold_quantity
			) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.category_id = category_id;
		this.supplier_id = supplier_id;
		this.image = image;
		this.images = images;
		this.stock_quantity = stock_quantity;
		this.sold_quantity = sold_quantity;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", description=" + description
				+ ", price=" + price + ", category_id=" + category_id + ", supplier_id="
				+ supplier_id + ", image=" + image + ", images=" + images + ", stock_quantity=" + stock_quantity
				+ ", sold_quantity=" + sold_quantity + "]";
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public int getSold_quantity() {
		return sold_quantity;
	}

	public void setSold_quantity(int sold_quantity) {
		this.sold_quantity = sold_quantity;
	}

}
