package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.Service;
import com.codegym.model.service.resort_service.ResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/service")
public class ServiceController {
    @Autowired
    private ResortService resortService;
    @GetMapping("/create")
    public ModelAndView getFormCreate(){
        return new ModelAndView("service-resort/create","service",new ServiceDto());
    }

}
