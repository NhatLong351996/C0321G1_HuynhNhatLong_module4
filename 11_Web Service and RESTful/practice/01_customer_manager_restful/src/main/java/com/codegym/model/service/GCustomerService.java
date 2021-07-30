package com.codegym.model.service;

import java.util.Optional;

public interface GCustomerService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
