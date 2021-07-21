package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    List<Product> findByName(String name);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);
}
