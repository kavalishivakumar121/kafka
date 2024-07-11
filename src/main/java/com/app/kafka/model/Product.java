package com.app.kafka.model;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private String product_name;
	private double product_price;
	private int product_quantity;
	private String email;
	private String phoneNo;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Product() {
		super();
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	@Override
	public String toString() {
		return "Product [product_name=" + product_name + ", product_price=" + product_price + ", product_quantity="
				+ product_quantity + ", phoneNo=" + phoneNo + "]";
	}
	
	
}
