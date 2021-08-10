package com.codegym.model.repository.contract_detail_repository;


import com.codegym.model.entity.ContractDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    List<ContractDetail> findByContract_IdContract(Long id);
    Page<ContractDetail> findByAttachService_NameAttachService(String name,Pageable pageable);
}
