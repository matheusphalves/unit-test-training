package com.matheusphalves.unittest.fundamentals.services;

import com.matheusphalves.unittest.fundamentals.models.Movie;
import com.matheusphalves.unittest.fundamentals.models.Allocation;
import com.matheusphalves.unittest.fundamentals.models.User;
import static com.matheusphalves.unittest.fundamentals.utils.DateUtil.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Date;

public class AllocationServiceTest {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void test() {

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
    public void testWithErrorCollector(){
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

}
