package com.codegym.model.repository.employee_repository;

import com.codegym.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByNameEmployeeContaining(String name, Pageable pageable);
}
