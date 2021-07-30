package com.codegym.restcontroller;


import com.codegym.entity.SmartPhone;
import com.codegym.service.SmartPhoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartPhoneRestController {
    @Autowired
    private SmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones", smartPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartphone(@PathVariable Long id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }
}

