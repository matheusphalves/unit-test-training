package com.matheusphalves.unittest.fundamentals.services;

import static com.matheusphalves.unittest.fundamentals.utils.DateUtil.addDays;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.matheusphalves.unittest.fundamentals.exceptions.MovieWithoutStockException;
import com.matheusphalves.unittest.fundamentals.exceptions.RentalCompanyException;
import com.matheusphalves.unittest.fundamentals.models.Movie;
import com.matheusphalves.unittest.fundamentals.models.Allocation;
import com.matheusphalves.unittest.fundamentals.models.User;
import com.matheusphalves.unittest.fundamentals.utils.DateUtil;

public class AllocationService {
	
	public Allocation allocateMovies(User user, List<Movie> movies) throws Exception, RentalCompanyException  {


		if(user == null){
			throw new RentalCompanyException("Empty user!");
		}

		if(movies == null || movies.isEmpty()){
			throw new RentalCompanyException("Empty movie!");
		}

		Allocation allocation = new Allocation();
		int movieCounter = 1;
		double discountRate = 0.25;

		for(Movie  movie: movies){

			if(movie.getStock() == 0){
				throw new MovieWithoutStockException("Movie without stock!");
			}

			allocation.addMovie(movie);
			allocation.setUsuario(user);
			allocation.setAllocationDate(new Date());

			if(movieCounter>=3 && movieCounter<= 6){
				movie.setAllocationPrice(movie.getAllocationPrice()*(1 - discountRate));
				discountRate+= 0.25;
			}
			allocation.increaseAllocationValue(movie.getAllocationPrice());
			movieCounter++;
		}

		//Entrega no dia seguinte
		Date returnDate = new Date();
		returnDate = addDays(returnDate, 1);

		if(DateUtil.checkDayOfWeek(returnDate, Calendar.SUNDAY)){
			returnDate = addDays(returnDate, 1);
		}
		allocation.setReturnDate(returnDate);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return allocation;
	}
}