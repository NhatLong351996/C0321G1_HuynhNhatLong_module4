package com.codegym.logg;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    int numberPeole=0;
    int numBorrow=0;
    int numReturn=0;
    @Pointcut(" within(com.codegym.controller.BookController)")
    public void signIn(){}
    @Before("signIn()")
    public void beforeSingIn(){
        numberPeole++;
        System.err.println("Have "+numberPeole+" sign in this library");
    }
    @Pointcut("execution(* com.codegym.controller.BookController.borrow(..))")
    public void borrow(){};
    @After("borrow()")
    public void afterBorrow(){
        numBorrow++;
        System.err.println("Have "+numBorrow+"  books are borrowed in this library");
    }
    @Pointcut("execution(* com.codegym.controller.BookController.returnBook(..))")
    public void returnBook(){};
    @After("returnBook()")
    public void afterReturnBook(){
        numReturn++;
        System.err.println("Have "+numReturn+"  books are returned in this library");
    }

}
