package com.matheusphalves.unittest.fundamentals.services;

import com.matheusphalves.unittest.fundamentals.models.Allocation;
import com.matheusphalves.unittest.fundamentals.models.Movie;
import com.matheusphalves.unittest.fundamentals.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Parameterized.class)
public class AllocationValueCalculatorTest {

    private AllocationService allocationService;

    @Parameterized.Parameter
    public List<Movie> movieList;

    @Parameterized.Parameter(value = 1)
    public Double allocationValue;

    @Parameterized.Parameter(value = 2)
    public String scenarioCounter;

    private final static Movie movie1 = new Movie("Movie 1", 4, 5.0);
    private final static Movie movie2 = new Movie("Movie 2", 3, 4.0);
    private final static Movie movie3 = new Movie("Movie 3", 2, 3.0);
    private final static Movie movie4 = new Movie("Movie 4", 2, 3.0);
    private final static Movie movie5 = new Movie("Movie 5", 2, 3.0);
    private final static Movie movie6 = new Movie("Movie 6", 2, 3.0);


    @Parameterized.Parameters(name = "{2}")
    public static Collection<Object[]> getParameters(){
        return Arrays.asList(new Object[][]{
                {Arrays.asList(movie1, movie2, movie3), 11.25, "3 movies: 25%"},
                {Arrays.asList(movie1, movie2, movie3, movie4), 12.1875, "4 movies: 50%"},
                {Arrays.asList(movie1, movie2, movie3, movie4, movie5), 11.765625, "5 movies: 75%"},
                {Arrays.asList(movie1, movie2, movie3, movie4, movie5, movie6), 10.51171875, "6 movies: 100%"}
        });
    }

    @Before
    public void setup(){
        allocationService = new AllocationService();
    }


    @Test
    public void testAllocationValueDiscount() throws Exception {
        User user = new User("User 1");

        Allocation allocation = allocationService.allocateMovies(user, movieList);

        Assert.assertThat(allocation.getAllocationValue(), is(allocationValue));
    }

    @Test
    public void print(){
        System.out.println(allocationValue);
    }


}
