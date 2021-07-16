package com.codgym.model.service;

public class CalculateException {
    public static void checkSecondNumber(float secondNumber) throws Exception {
        if (secondNumber==0){
            throw new Exception("Can't divide by zero with second number");
        }
    }
}
