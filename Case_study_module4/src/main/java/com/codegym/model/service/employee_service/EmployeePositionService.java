package com.codegym.model.service.employee_service;

import com.codegym.model.entity.PositionEmployee;
import com.codegym.model.repository.employee_repository.IEmployeePositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EmployeePositionService implements IEmployeePositionService {
    @Autowired
    private IEmployeePositionRepo iEmployeePositionRepo;
    @Override
    public List<PositionEmployee> findAll() {
        return iEmployeePositionRepo.findAll();
    }
}
