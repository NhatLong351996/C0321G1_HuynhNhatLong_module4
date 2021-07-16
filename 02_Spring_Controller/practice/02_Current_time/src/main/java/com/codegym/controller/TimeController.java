package com.codegym.controller;

import com.codegym.model.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @Autowired
    DateService dateService;
    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city",
            required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = dateService.getTimeByTimeZone(city);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
