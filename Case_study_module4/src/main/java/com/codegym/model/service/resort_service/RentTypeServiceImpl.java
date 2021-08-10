package com.codegym.model.service.resort_service;

import com.codegym.model.entity.RentTypeService;
import com.codegym.model.repository.customer_repository.RentTypeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements IRentTypeService{
    @Autowired
    private RentTypeServiceRepository rentTypeServiceRepository;
    @Override
    public List<RentTypeService> findAll() {
        return rentTypeServiceRepository.findAll();
    }
}
