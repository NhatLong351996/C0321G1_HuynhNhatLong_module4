package com.codegym.controller;

import com.codegym.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView getForm(){
        return new ModelAndView("login","user",new User());
    }
}
