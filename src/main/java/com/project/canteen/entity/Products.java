package com.project.canteen.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	private String image;
	private boolean available;
	private int stock;
	
	public Products() {
		
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", available="
				+ available + ", stock=" + stock + "]";
	}
	
	
	
}
