package com.codegym.model.service.contract_detail_service;

import com.codegym.model.entity.ContractDetail;
import com.codegym.model.repository.contract_detail_repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findByContract_IdContract(Long id) {
        return contractDetailRepository.findByContract_IdContract(id);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Page<ContractDetail> findByAttachService_NameAttachService(String name, Pageable pageable) {
        return contractDetailRepository.findByAttachService_NameAttachService(name,pageable);
    }
}
