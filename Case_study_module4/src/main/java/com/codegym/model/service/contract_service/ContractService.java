package com.codegym.model.service.contract_service;

import com.codegym.dto.ContractDto;
import com.codegym.model.entity.Contract;
import com.codegym.model.repository.contract_repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findByYear(String year, Pageable pageable) {
        return iContractRepository.findByYear(year,pageable);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }
}
