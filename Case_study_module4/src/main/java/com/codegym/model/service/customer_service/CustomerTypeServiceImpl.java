package com.codegym.model.service.customer_service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.CustomerType;
import com.codegym.model.repository.customer_repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService{
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
