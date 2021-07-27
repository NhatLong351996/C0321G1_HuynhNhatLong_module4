package com.codegym.logg;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    int numberPeole=0;
    @Pointcut(" execution(* com.codegym.controller.BookController.getList(..))")
    public void signIn(){}
    @Before("signIn()")
    public void beforeSingIn(){
        numberPeole++;
        System.err.println("Have "+numberPeole+" sign in this library");
    }

}
