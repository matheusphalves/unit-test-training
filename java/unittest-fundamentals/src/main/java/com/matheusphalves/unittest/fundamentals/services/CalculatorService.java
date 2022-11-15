package com.matheusphalves.unittest.fundamentals.services;

import com.matheusphalves.unittest.fundamentals.exceptions.DivisionByZeroException;

public class CalculatorService {

    public int sum(int operandA, int operandB){
        return operandA + operandB;
    }

    public int sub(int operandA, int operandB){
        return operandA - operandB;
    }


    public int multiply(int operandA, int operandB){
        return operandA * operandB;
    }

    public int division(int operandA, int operandB) throws DivisionByZeroException {
        if(operandB == 0){
            throw new DivisionByZeroException("operandB can't be zero!");
        }
        return operandA / operandB;
    }


}
