package com.matheusphalves.unittest.fundamentals.models;

public class Movie {

	private String name;
	private Integer stock;
	private Double allocationPrice;
	
	public Movie() {}
	
	public Movie(String name, Integer stock, Double allocationPrice) {
		this.name = name;
		this.stock = stock;
		this.allocationPrice = allocationPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Double getAllocationPrice() {
		return allocationPrice;
	}
	public void setAllocationPrice(Double allocationPrice) {
		this.allocationPrice = allocationPrice;
	}
}