package com.codgym.model.service;

import com.codgym.exception.CalculateException;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {
    @Override
    public String calculate(float firstNumber,float seconNumber,String operator){
        int resultInt = 0;
        String resultString="";
        try {
        switch (operator){
            case "+":
                resultInt = (int) (firstNumber+seconNumber);
                break;
            case "-":
                resultInt = (int) (firstNumber-seconNumber);
                break;
            case "*":
                resultInt = (int) (firstNumber*seconNumber);
                break;
            case "/":
                CalculateException.checkSecondNumber(seconNumber);
                resultInt = (int) (firstNumber/seconNumber);
                break;
        }
        resultString = ""+resultInt;
        } catch (Exception e) {
            resultString = e.getMessage();
        }
        return resultString;
    }
}
