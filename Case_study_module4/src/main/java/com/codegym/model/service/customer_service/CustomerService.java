package com.codegym.model.service.customer_service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
     Page<Customer> findAll(Pageable pageable);
     List<Customer> findAll();
     void save(Customer customer);
     Customer findById(Long id);
     void delete(Customer customer);
     Page<Customer> findByNameCustomerContaining(String name, Pageable pageable);
}
