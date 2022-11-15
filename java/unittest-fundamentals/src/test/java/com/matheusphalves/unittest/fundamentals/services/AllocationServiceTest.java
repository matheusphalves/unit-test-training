package com.matheusphalves.unittest.fundamentals.services;

import com.matheusphalves.unittest.fundamentals.exceptions.MovieWithoutStockException;
import com.matheusphalves.unittest.fundamentals.exceptions.RentalCompanyException;
import com.matheusphalves.unittest.fundamentals.models.Movie;
import com.matheusphalves.unittest.fundamentals.models.Allocation;
import com.matheusphalves.unittest.fundamentals.models.User;
import static com.matheusphalves.unittest.fundamentals.utils.DateUtil.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllocationServiceTest {

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private AllocationService allocationService;

    private List<Movie> movies;

    private User user;

    @Before
    public void setup(){
        System.out.println("Before");
        allocationService = new AllocationService();

        user = new User("User 1");


        movies = new ArrayList<>();

        Movie movie1 = new Movie("Movie 1", 3, 5.0);
        Movie movie2 = new Movie("Movie 2", 2, 4.0);
        Movie movie3 = new Movie("Movie 3", 1, 3.0);

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

    }

    @After
    public void tearDown(){
        System.out.println("After");
    }

    @BeforeClass
    public static void setupClass(){
        System.out.println("Before class");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("After class");
    }

    @Test
    public void test() throws Exception {

        /* Fast, Independent, Repeatable, Self-Verifying, Timely */

        //action
        Allocation allocation = allocationService.allocateMovies(user, movies);

        //check
        assertEquals(12.0, allocation.getAllocationValue(), 0.01);
        assertThat(allocation.getAllocationValue(), is(equalTo(12.0)));
        assertThat(allocation.getAllocationValue(), is(not(5.0)));

        assertTrue(isSameDate(allocation.getAllocationDate(), new Date()));
        assertTrue(isSameDate(allocation.getReturnDate(), getDateWithDaysDiff(1)));

    }

    @Test
    public void testWithErrorCollector() throws Exception {
        //scenario

        //action
        Allocation allocation = allocationService.allocateMovies(user, movies);

        //check
        errorCollector.checkThat(allocation.getAllocationValue(), is(equalTo(12.0)));
        errorCollector.checkThat(allocation.getAllocationValue(), is(not(4.0)));

        errorCollector.checkThat(isSameDate(allocation.getAllocationDate(), new Date()), is(true));
        errorCollector.checkThat(isSameDate(allocation.getReturnDate(), getDateWithDaysDiff(1)), is(true));
    }

    @Test(expected = MovieWithoutStockException.class)
    public void testAllocationMovieWithoutStock() throws Exception {
        //scenario
        Movie movie = new Movie("Movie 4", 0, 2.0);
        movies.add(movie);
        //action
        Allocation allocation = allocationService.allocateMovies(user, movies);
    }

    @Test
    public void testAllocationMovieWithoutStock2() {
        //scenario
        Movie movie = new Movie("Movie 4", 0, 2.0);
        movies.add(movie);

        //action
        try {

            Allocation allocation = allocationService.allocateMovies(user, movies);
            fail("Should throw an exception!");

        } catch (Exception e) {
            Assert.assertThat(e.getMessage(), is("Movie without stock!"));
        }
    }

    @Test
    public void testAllocationMovieWithoutStock3() throws Exception {
        //scenario
        Movie movie = new Movie("Movie 4", 0, 2.0);
        movies.add(movie);

        expectedException.expect(Exception.class);
        expectedException.expectMessage("Movie without stock!");


        //action
        Allocation allocation = allocationService.allocateMovies(user, movies);
    }

    @Test
    public void testAllocationEmptyUser() throws Exception{

        //action
        try {

            Allocation allocation = allocationService.allocateMovies(null, movies);
            fail("Should throw an exception!");

        } catch (RentalCompanyException e) {
            Assert.assertThat(e.getMessage(), is("Empty user!"));
        }

    }

    @Test
    public void testAllocationEmptyMovie() throws Exception {
        //scenario
        expectedException.expect(RentalCompanyException.class);
        expectedException.expectMessage("Empty movie!");


        //action
        Allocation allocation = allocationService.allocateMovies(user, null);
    }

}
