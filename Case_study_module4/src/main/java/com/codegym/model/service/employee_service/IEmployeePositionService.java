package com.codegym.model.service.employee_service;

import com.codegym.model.entity.PositionEmployee;

import java.util.List;

public interface IEmployeePositionService {
    List<PositionEmployee> findAll();
}
