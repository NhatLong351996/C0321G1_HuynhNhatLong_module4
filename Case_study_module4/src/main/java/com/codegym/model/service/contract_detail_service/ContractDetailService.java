package com.codegym.model.service.contract_detail_service;

import com.codegym.model.entity.ContractDetail;
import com.codegym.dto.IContractDetailDto;
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
    public Page<ContractDetail> findAllByAttachService_NameAttachService(String name, Pageable pageable) {
        return contractDetailRepository.findAllByAttachService_NameAttachService(name,pageable);
    }

    @Override
    public Page<IContractDetailDto> listFindByNameAttach(Pageable pageable, String name) {
        return contractDetailRepository.listFindByNameAttach(pageable,name);
    }

    @Override
    public Page<IContractDetailDto> listFindAll(Pageable pageable) {
        return contractDetailRepository.listFindAll(pageable);
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).get();
    }

    @Override
    public void delete(ContractDetail contractDetail) {
        contractDetailRepository.delete(contractDetail);
    }
}
