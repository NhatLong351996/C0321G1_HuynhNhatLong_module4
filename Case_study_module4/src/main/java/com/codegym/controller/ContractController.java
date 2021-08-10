package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.entity.Contract;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import com.codegym.model.entity.Service;
import com.codegym.model.service.contract_detail_service.IContractDetailService;
import com.codegym.model.service.contract_service.IContractService;
import com.codegym.model.service.customer_service.CustomerService;
import com.codegym.model.service.employee_service.EmployeeService;
import com.codegym.model.service.resort_service.ResortService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ResortService resortService;
    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute("listEmployee")
    public List<Employee> getListEmployee() {
        return employeeService.findAll();
    }

    @ModelAttribute("listCustomer")
    public List<Customer> getListCustomer() {
        return customerService.findAll();
    }

    @ModelAttribute("listService")
    public List<Service> getListService() {
        return resortService.findAll();
    }

    @GetMapping
    public ModelAndView getFormCreate() {
        return new ModelAndView("contract/create", "contractDto",
                new ContractDto());
    }

    @PostMapping
    public ModelAndView create(@Valid @ModelAttribute ContractDto contractDto,
                               BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("contractDto", contractDto);
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            contractService.save(contract);
            modelAndView.addObject("contractDto", new ContractDto());
            modelAndView.addObject("message","Contract have been created!");
        }
        return modelAndView;
    }
   /* @GetMapping("/list")
    public ModelAndView getFormListContract(@PageableDefault(value = 5) Pageable pageable,
                                            @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("contract/list");
        Page<Contract> contracts;
        if (search.isPresent()) {
            contracts = contractService.findByYear(search.get(), pageable);
        } else {
            contracts = contractService.findAll(pageable);
        }
        modelAndView.addObject("contracts", contracts);
        modelAndView.addObject("search", search.orElse(null));
        return modelAndView;
    }*/
}
