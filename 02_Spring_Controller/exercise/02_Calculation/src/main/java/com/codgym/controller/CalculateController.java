package com.codgym.controller;

import com.codgym.model.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    CalculateService calculateService;

    @GetMapping("/")
    public String getForm() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam float firstnumber,
                            @RequestParam float secondnumber,
                            @RequestParam String operator, Model model) {
       
        String result = calculateService.calculate(firstnumber, secondnumber, operator);
        model.addAttribute("result", result);
        return "index";
    }
}
