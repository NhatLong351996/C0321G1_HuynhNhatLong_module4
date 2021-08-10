package com.codegym.model.service.resort_service;

import com.codegym.model.entity.ServiceType;
import com.codegym.model.repository.resort_service_repository.TypeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeServiceRepository typeServiceRepository;

    @Override
    public List<ServiceType> findAll() {
        return typeServiceRepository.findAll();
    }
}
