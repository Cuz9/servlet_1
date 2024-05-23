package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private String image;
	private Category category;

	public Product() {
	}

	public Product(ResultSet rs, Category catergoryParam) throws SQLException {

		super();
		this.id = rs.getInt("id");
		this.name = rs.getString("name");
		this.price = rs.getDouble("price");
		this.quantity = rs.getInt("quantity");
		this.image = rs.getString("image");
		this.category = catergoryParam;
	}

	public Product(int id, String name, double price, int quantity, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public Product(int id, String name, double price, int quantity, String image, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
