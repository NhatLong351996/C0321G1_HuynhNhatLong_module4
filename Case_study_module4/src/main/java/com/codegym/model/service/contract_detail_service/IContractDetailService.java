package com.codegym.model.service.contract_detail_service;

import com.codegym.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);
    List<ContractDetail> findByContract_IdContract(Long id);
    Page<ContractDetail> findAll(Pageable pageable);
    Page<ContractDetail> findByAttachService_NameAttachService(String name,Pageable pageable);
}
