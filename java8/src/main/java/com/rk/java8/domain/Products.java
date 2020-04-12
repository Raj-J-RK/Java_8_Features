package com.rk.java8.domain;

import java.math.BigDecimal;

public class Products {
	
	private String productId;
	private String productName;
	private String brandName;
	private int stock;
	private BigDecimal amount;
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", brandName=" + brandName
				+ ", stock=" + stock + ", amount=" + amount + "]";
	}

}
