package com.codegym.model.service.employee_service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll();
    void save(Employee employee);
    Employee findById(Long id);
    void delete(Employee employee);
    Page<Employee> findByNameEmployeeContaining(String name, Pageable pageable);
}
