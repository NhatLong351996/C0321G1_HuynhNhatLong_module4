package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTest {
    @GetMapping({"/home","/"})
    public String get(){
        return "home/home";
    }

    @GetMapping("/list")
    public String getlist(){
        return "customer/list";
    }
}
