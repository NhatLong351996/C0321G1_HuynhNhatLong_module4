package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import com.codegym.model.service.customer_service.CustomerService;
import com.codegym.model.service.customer_service.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("listTypeCustomer")
    public List<CustomerType> getListCustomerType() {
        return customerTypeService.findAll();
    }

    @GetMapping
    public ModelAndView getFormCreateCustomer(@PageableDefault(value = 3) Pageable pageable,
                                              @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        Page<Customer> customers;
        if (search.isPresent()){
            customers = customerService.findByNameCustomerContaining(search.get(),pageable);
        }else {
           customers = customerService.findAll(pageable);
        }
        modelAndView.addObject("customers",customers);
        modelAndView.addObject("search",search.orElse(null));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getFormCreate() {
        return new ModelAndView("/customer/create", "customerDto", new CustomerDto());
    }

    @PostMapping("/create")
    public ModelAndView createCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                                       BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("customerDto", customerDto);
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            modelAndView.addObject("customerDto", new CustomerDto());
            modelAndView.addObject("message",
                    customer.getNameCustomer() + " create success!");
        }
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return new ModelAndView("customer/edit", "customerDto", customerDto);
    }

    @PostMapping("/edit")
    public ModelAndView update(@Valid @ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("customerDto", customerDto);
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            modelAndView.addObject("customerDto", customerDto);
            modelAndView.addObject("message",
                    customerDto.getNameCustomer() + " update success!");
        }
        return modelAndView;
    }
    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id,
                               RedirectAttributes redirectAttributes){
        Customer customer = customerService.findById(id);
        customerService.delete(customer);
        redirectAttributes.addFlashAttribute("message",customer.getNameCustomer()+"delete success!");
        return new ModelAndView("redirect:/customer");
    }


}
