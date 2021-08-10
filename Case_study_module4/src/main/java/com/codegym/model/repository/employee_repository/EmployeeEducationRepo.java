package com.codegym.model.repository.employee_repository;

import com.codegym.model.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeEducationRepo extends JpaRepository<EducationDegree,Long> {
}
