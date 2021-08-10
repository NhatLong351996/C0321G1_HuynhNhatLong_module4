package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.entity.RentTypeService;
import com.codegym.model.entity.Service;
import com.codegym.model.entity.ServiceType;
import com.codegym.model.service.resort_service.IRentTypeService;
import com.codegym.model.service.resort_service.ResortService;
import com.codegym.model.service.resort_service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ResortService resortService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @ModelAttribute("typeServices")
    public List<ServiceType> getListTypeServices(){
        return typeService.findAll();
    }
    @ModelAttribute("rentTypeServices")
    public List<RentTypeService> getListRentTypeServices(){
        return iRentTypeService.findAll();
    }
    @GetMapping("/create")
    public ModelAndView getFormCreate(){
        return new ModelAndView("/service-resort/create",
                "serviceDto",new ServiceDto());
    }
    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute ServiceDto serviceDto,
                               BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/service-resort/create");
        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("serviceDto",serviceDto);
        }else {
            Service service=new Service();
            BeanUtils.copyProperties(serviceDto,service);
            resortService.save(service);
            modelAndView.addObject("message",
                    service.getNameService()+" create success!");
            modelAndView.addObject("serviceDto",new ServiceDto());
        }
        return modelAndView;
    }

}
