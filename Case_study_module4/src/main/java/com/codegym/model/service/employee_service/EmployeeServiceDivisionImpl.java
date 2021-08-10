package com.codegym.model.service.employee_service;

import com.codegym.model.entity.EmployeeDivision;
import com.codegym.model.repository.employee_repository.EmployeeDivisionRepo;
import com.codegym.model.repository.employee_repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceDivisionImpl implements EmployeeDivisionService{
    @Autowired
    private EmployeeDivisionRepo employeeDivisionRepo;
    @Override
    public List<EmployeeDivision> findAll() {
        return employeeDivisionRepo.findAll();
    }
}
