package com.codegym.controller;

import com.codegym.model.dto.CustomerDto;
import com.codegym.model.entity.Customer;
import com.codegym.model.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity addNewCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getListCustomer() {
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity putCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.findById(customerDto.getId()).get();
        if (customer == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customerService.save(customer);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if (!optionalCustomer.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
