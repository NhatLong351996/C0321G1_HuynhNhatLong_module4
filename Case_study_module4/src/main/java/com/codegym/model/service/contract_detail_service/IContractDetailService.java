package com.codegym.model.service.contract_detail_service;

import com.codegym.model.entity.ContractDetail;
import com.codegym.dto.IContractDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);
    List<ContractDetail> findByContract_IdContract(Long id);
    Page<ContractDetail> findAll(Pageable pageable);
    Page<ContractDetail> findAllByAttachService_NameAttachService(String name,Pageable pageable);
    Page<IContractDetailDto> listFindByNameAttach(Pageable pageable,String name);
    Page<IContractDetailDto> listFindAll(Pageable pageable);
    ContractDetail findById(Long id);
    void delete(ContractDetail contractDetail);
}
