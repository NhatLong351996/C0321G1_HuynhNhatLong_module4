package com.codegym.model.service.contract_service;

import com.codegym.dto.ContractDto;
import com.codegym.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractService {
    void save(Contract contract);
    List<Contract> findAll();
    Page<Contract> findByYear(String year, Pageable pageable);
    Page<Contract> findAll(Pageable pageable);
}
