package com.codegym.controller;

import com.codegym.model.dto.UserDto;
import com.codegym.model.entity.User;
import com.codegym.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("/create")
    public ModelAndView getFormCreate() {
        return new ModelAndView("create", "userDto", new UserDto());
    }

    @PostMapping("/create")
    public ModelAndView saveUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                                 BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("create");
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("userDto",userDto);
            return modelAndView;
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            modelAndView.addObject("message", "user have been created!");
            modelAndView.addObject("userDto", new UserDto());
            return modelAndView;
        }
    }
}
