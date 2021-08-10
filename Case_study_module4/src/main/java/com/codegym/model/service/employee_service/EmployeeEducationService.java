package com.codegym.model.service.employee_service;

import com.codegym.model.entity.EducationDegree;
import com.codegym.model.repository.employee_repository.EmployeeEducationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeEducationService implements IEmployeeEducationService{
    @Autowired
    private EmployeeEducationRepo employeeEducationRepo;
    @Override
    public List<EducationDegree> findAll() {
        return employeeEducationRepo.findAll();
    }
}
