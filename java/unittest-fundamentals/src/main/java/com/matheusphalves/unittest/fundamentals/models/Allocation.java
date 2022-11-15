package com.matheusphalves.unittest.fundamentals.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Allocation {

	private User user;
	private List<Movie> movies;
	private Date allocationDate;
	private Date returnDate;
	private Double allocationValue;
	

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


	public void addMovie(Movie movie){

		if(this.movies==null){
			this.movies = new ArrayList<>();

		}
		this.movies.add(movie);
	}

	public void increaseAllocationValue(Double allocationValue){
		if(this.allocationValue == null){
			this.allocationValue = allocationValue;
		}else{
			this.allocationValue += allocationValue;
		}

	}
}