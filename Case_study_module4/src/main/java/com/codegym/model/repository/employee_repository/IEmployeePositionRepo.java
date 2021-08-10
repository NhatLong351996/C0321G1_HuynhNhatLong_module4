package com.codegym.model.repository.employee_repository;

import com.codegym.model.entity.PositionEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeePositionRepo extends JpaRepository<PositionEmployee,Long> {
}
