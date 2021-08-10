package com.codegym.model.service.resort_service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Service;

import java.util.List;

public interface ResortService {
    void save(Service service);
    List<Service> findAll();
}
