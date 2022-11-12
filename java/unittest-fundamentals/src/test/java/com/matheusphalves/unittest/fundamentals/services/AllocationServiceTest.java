package com.matheusphalves.unittest.fundamentals.services;

import com.matheusphalves.unittest.fundamentals.models.Movie;
import com.matheusphalves.unittest.fundamentals.models.Allocation;
import com.matheusphalves.unittest.fundamentals.models.User;
import com.matheusphalves.unittest.fundamentals.utils.DateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class AllocationServiceTest {

    @Test
    public void teste() {

        /* Fast, Independent, Repeatable, Self-Verifying, Timely */

        //cenario
        AllocationService allocationService = new AllocationService();
        User user = new User("Usuario 1");
        Movie movie = new Movie("Filme 1", 2, 5.0);


        //acao
        Allocation allocation = allocationService.allocateMovie(user, movie);

        //verificacao
        Assert.assertEquals(5.0, allocation.getAllocationValue(), 0.01);
        Assert.assertTrue(DateUtil.isSameDate(allocation.getAllocationDate(), new Date()));
        Assert.assertTrue(DateUtil.isSameDate(allocation.getReturnDate(), DateUtil.getDateWithDaysDiff(1)));

    }

}
