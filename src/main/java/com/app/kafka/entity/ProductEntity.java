package com.app.kafka.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_table")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String prod_name;
	private double prod_price;
	private Integer prod_quantity;
	private Long phoneNo;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public ProductEntity() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	public Integer getProd_quantity() {
		return prod_quantity;
	}
	public void setProd_quantity(Integer prod_quantity) {
		this.prod_quantity = prod_quantity;
	}
	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", prod_name=" + prod_name + ", prod_price=" + prod_price
				+ ", prod_quantity=" + prod_quantity + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	
	
	

}
