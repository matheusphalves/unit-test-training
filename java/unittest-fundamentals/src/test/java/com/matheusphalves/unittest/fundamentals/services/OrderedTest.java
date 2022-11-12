package com.matheusphalves.unittest.fundamentals.services;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderedTest {


    public static int counter = 0;

    @Test
    public void t1Test(){
        counter = 1;
    }

    @Test
    public void t2Test(){
        Assert.assertEquals(1, counter);
    }

}
