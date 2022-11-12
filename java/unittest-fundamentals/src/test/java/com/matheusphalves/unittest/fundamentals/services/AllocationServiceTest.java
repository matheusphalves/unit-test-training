package com.matheusphalves.unittest.fundamentals.services;

import com.matheusphalves.unittest.fundamentals.exceptions.MovieWithoutStockException;
import com.matheusphalves.unittest.fundamentals.exceptions.RentalCompanyException;
import com.matheusphalves.unittest.fundamentals.models.Movie;
import com.matheusphalves.unittest.fundamentals.models.Allocation;
import com.matheusphalves.unittest.fundamentals.models.User;
import static com.matheusphalves.unittest.fundamentals.utils.DateUtil.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.Date;

public class AllocationServiceTest {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();


    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void test() throws Exception {

        /* Fast, Independent, Repeatable, Self-Verifying, Timely */

        //scenario
        AllocationService allocationService = new AllocationService();
        User user = new User("Usuario 1");
        Movie movie = new Movie("Filme 1", 2, 5.0);


        //action
        Allocation allocation = allocationService.allocateMovie(user, movie);

        //check
        assertEquals(5.0, allocation.getAllocationValue(), 0.01);
        assertThat(allocation.getAllocationValue(), is(equalTo(5.0)));
        assertThat(allocation.getAllocationValue(), is(not(4.0)));

        assertTrue(isSameDate(allocation.getAllocationDate(), new Date()));
        assertTrue(isSameDate(allocation.getReturnDate(), getDateWithDaysDiff(1)));

    }

    @Test
    public void testWithErrorCollector() throws Exception {
        //scenario
        AllocationService allocationService = new AllocationService();
        User user = new User("Usuario 1");
        Movie movie = new Movie("Filme 1", 2, 5.0);


        //action
        Allocation allocation = allocationService.allocateMovie(user, movie);

        //check
        errorCollector.checkThat(allocation.getAllocationValue(), is(equalTo(5.0)));
        errorCollector.checkThat(allocation.getAllocationValue(), is(not(4.0)));

        errorCollector.checkThat(isSameDate(allocation.getAllocationDate(), new Date()), is(false));
        errorCollector.checkThat(isSameDate(allocation.getReturnDate(), getDateWithDaysDiff(1)), is(false));
    }

    @Test(expected = MovieWithoutStockException.class)
    public void testAllocationMovieWithoutStock() throws Exception {
        //scenario
        AllocationService allocationService = new AllocationService();
        User user = new User("Usuario 1");
        Movie movie = new Movie("Filme 1", 0, 5.0);


        //action
        Allocation allocation = allocationService.allocateMovie(user, movie);
    }

    @Test
    public void testAllocationMovieWithoutStock2() {
        //scenario
        AllocationService allocationService = new AllocationService();
        User user = new User("Usuario 1");
        Movie movie = new Movie("Filme 1", 0, 5.0);


        //action
        try {

            Allocation allocation = allocationService.allocateMovie(user, movie);
            fail("Should throw an exception!");

        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Movie without stock!"));
        }
    }

    @Test
    public void testAllocationMovieWithoutStock3() throws Exception {
        //scenario
        AllocationService allocationService = new AllocationService();
        User user = new User("Usuario 1");
        Movie movie = new Movie("Filme 1", 0, 5.0);

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Movie without stock!");


        //action
        Allocation allocation = allocationService.allocateMovie(user, movie);
    }

    @Test
    public void testAllocationEmptyUser() throws Exception{
        //scenario
        AllocationService allocationService = new AllocationService();
        Movie movie = new Movie("Filme 1", 1, 5.0);

        //action
        try {

            Allocation allocation = allocationService.allocateMovie(null, movie);
            fail("Should throw an exception!");

        } catch (RentalCompanyException e) {
            Assert.assertThat(e.getMessage(), is("Empty user!"));
        }

    }

    @Test
    public void testAllocationEmptyMovie() throws Exception {
        //scenario
        AllocationService allocationService = new AllocationService();
        User user = new User("Usuario 1");

        expectedException.expect(RentalCompanyException.class);
        expectedException.expectMessage("Empty movie!");


        //action
        Allocation allocation = allocationService.allocateMovie(user, null);
    }

}
