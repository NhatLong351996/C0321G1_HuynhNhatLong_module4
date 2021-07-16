package com.codegym.controller;

import com.codegym.model.bean.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @GetMapping("/create")
    public ModelAndView creatEmail() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("email", new Email());
        modelAndView.addObject("languagesArray", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSizeArray", new int[]{5, 10, 15, 25, 50, 100});
        return modelAndView;
    }

    @PostMapping("/infor")
    public ModelAndView showInformation(@ModelAttribute("email") Email email) {
        ModelAndView modelAndView = new ModelAndView("infor");
        modelAndView.addObject("email", email);
        return modelAndView;
    }
}
