package com.codegym.model.service.resort_service;

import com.codegym.model.entity.Service;
import com.codegym.model.repository.resort_service_repository.ServiceResortRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ResortServiceImpl implements ResortService{
    @Autowired
    private ServiceResortRepository serviceResortRepository;
    @Override
    public void save(Service service) {
        serviceResortRepository.save(service);
    }
}
