package com.codegym.controller;

import com.codegym.dto.PhoneNumberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/phone")
    public String showForm(Model model){
        model.addAttribute("phoneNumberDto", new PhoneNumberDto());
        return "/index";
    }
    @PostMapping("/phone")
    public String checkValidation (@Valid @ModelAttribute("phoneNumberDto")PhoneNumberDto phoneNumberDto,
                                   BindingResult bindingResult,
                                   Model model){
        new PhoneNumberDto().validate(phoneNumberDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            model.addAttribute("phoneNumberDto", phoneNumberDto);
            return "/result";
        }
    }
}
