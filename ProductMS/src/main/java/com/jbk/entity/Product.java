package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.jbk.model.Category;
import com.jbk.model.Supplier;

@Entity
@Table
public class Product {

	@Id
	@Column(unique = true, nullable = false)
	private String productId;

	@NotEmpty(message = "Product Name Is Required")
	@Column(unique = true, nullable = false)
	private String productName;

	@Column(nullable = false)
	@Min(1)
	private int supplierid;

	@Column(nullable = false)
	@Min(1)
	private int categoryid;

	@Column(nullable = false)
	@Min(1)
	private int productQty;
	
	@Column(nullable = false)
	@Min(1)
	private double productPrice;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, @NotEmpty(message = "Product Name Is Required") String productName,
			@Min(1) int supplierid, @Min(1) int categoryid, @Min(1) int productQty, @Min(1) double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierid = supplierid;
		this.categoryid = categoryid;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierid=" + supplierid
				+ ", categoryid=" + categoryid + ", productQty=" + productQty + ", productPrice=" + productPrice + "]";
	}

	
}
