package com.codegym.model.service.customer_service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
     Page<Customer> findAll(Pageable pageable);
     void save(Customer customer);
     Customer findById(Long id);
     void delete(Customer customer);
     Page<Customer> findByNameCustomerContaining(String name, Pageable pageable);
}
