package com.matheusphalves.unittest.fundamentals.services;

import com.matheusphalves.unittest.fundamentals.exceptions.DivisionByZeroException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {

    private CalculatorService calcService;

    @Before
    public void setup(){
        calcService = new CalculatorService();
    }

    @Test
    public void testSum(){
        //scenario
        int operandA = 5;
        int operandB = 3;

        //action
        int sumResult = calcService.sum(operandA, operandB);
        //check
        assertEquals(8, sumResult);
    }

    @Test
    public void testSub(){
        int operandA = 5;
        int operandB = 3;

        int subResult = calcService.sub(operandA, operandB);
        assertEquals(2, subResult);

    }

    @Test
    public void testMultiply(){
        int operandA = 5;
        int operandB = 3;

        int multiplyResult = calcService.multiply(operandA, operandB);
        assertEquals(15, multiplyResult);

    }


    @Test
    public void testDivision() throws DivisionByZeroException {
        int operandA = 5;
        int operandB = 3;

        int divisionResult = calcService.division(operandA, operandB);
        assertEquals(1, divisionResult);

    }

    @Test
    public void testDivisionByZero() throws DivisionByZeroException {
        int operandA = 5;
        int operandB = 0;

        try{
            int divisionResult = calcService.division(operandA, operandB);
            fail("Should throws an exception!");
        }catch (DivisionByZeroException divisionByZeroException){
            assertEquals("operandB can't be zero!", divisionByZeroException.getMessage());
        }

    }

}
