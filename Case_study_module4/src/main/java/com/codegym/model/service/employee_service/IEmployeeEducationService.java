package com.codegym.model.service.employee_service;

import com.codegym.model.entity.EducationDegree;

import java.util.List;

public interface IEmployeeEducationService {
    List<EducationDegree> findAll();
}
