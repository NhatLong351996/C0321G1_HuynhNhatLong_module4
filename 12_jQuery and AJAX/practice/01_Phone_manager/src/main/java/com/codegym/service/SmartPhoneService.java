package com.codegym.service;

import com.codegym.entity.SmartPhone;

import java.util.Optional;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
