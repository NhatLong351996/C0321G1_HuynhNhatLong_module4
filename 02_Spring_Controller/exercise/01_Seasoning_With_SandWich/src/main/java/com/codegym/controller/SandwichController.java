package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String menu() {
        return "index";
    }
    @GetMapping("/save")
    public String save(@RequestParam String[] condiment , Model model ){
        model.addAttribute("result",condiment);
        return "index";
    }
}
