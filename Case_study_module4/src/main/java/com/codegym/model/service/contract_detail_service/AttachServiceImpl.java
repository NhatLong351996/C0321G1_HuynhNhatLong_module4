package com.codegym.model.service.contract_detail_service;

import com.codegym.model.entity.AttachService;
import com.codegym.model.repository.contract_detail_repository.IAttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceImpl implements IAttachService {
    @Autowired
    private IAttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
