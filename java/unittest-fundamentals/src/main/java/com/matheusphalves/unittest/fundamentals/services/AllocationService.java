package com.matheusphalves.unittest.fundamentals.services;

import static com.matheusphalves.unittest.fundamentals.utils.DateUtil.addDays;

import java.util.Date;

import com.matheusphalves.unittest.fundamentals.exceptions.MovieWithoutStockException;
import com.matheusphalves.unittest.fundamentals.exceptions.RentalCompanyException;
import com.matheusphalves.unittest.fundamentals.models.Movie;
import com.matheusphalves.unittest.fundamentals.models.Allocation;
import com.matheusphalves.unittest.fundamentals.models.User;

public class AllocationService {
	
	public Allocation allocateMovie(User user, Movie movie) throws Exception, RentalCompanyException  {


		if(user == null){
			throw new RentalCompanyException("Empty user!");
		}

		if(movie == null){
			throw new RentalCompanyException("Empty movie!");
		}

		if(movie.getStock() == 0){
			throw new MovieWithoutStockException("Movie without stock!");
		}

		Allocation allocation = new Allocation();
		allocation.setFilme(movie);
		allocation.setUsuario(user);
		allocation.setAllocationDate(new Date());
		allocation.setAllocationValue(movie.getAllocationPrice());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = addDays(dataEntrega, 1);
		allocation.setReturnDate(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return allocation;
	}
}