package com.matheusphalves.unittest.fundamentals.models;

import java.util.Date;

public class Allocation {

	private User user;
	private Movie movie;
	private Date allocationDate;
	private Date returnDate;
	private Double allocationValue;
	
	public User getUsuario() {
		return user;
	}
	public void setUsuario(User user) {
		this.user = user;
	}
	public Date getAllocationDate() {
		return allocationDate;
	}
	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Double getAllocationValue() {
		return allocationValue;
	}
	public void setAllocationValue(Double allocationValue) {
		this.allocationValue = allocationValue;
	}
	public Movie getFilme() {
		return movie;
	}
	public void setFilme(Movie movie) {
		this.movie = movie;
	}
}