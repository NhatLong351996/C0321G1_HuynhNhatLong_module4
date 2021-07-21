package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "product1", 100000, "describe1", "produce1"));
        products.put(2, new Product(2, "product2", 200000, "describe2", "produce2"));
        products.put(3, new Product(3, "product3", 300000, "describe3", "produce3"));
        products.put(4, new Product(4, "product2", 400000, "describe4", "produce4"));
        products.put(5, new Product(5, "product3", 500000, "describe5", "produce5"));
        products.put(6, new Product(6, "product1", 600000, "describe6", "produce6"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        for (Product product : new ArrayList<>(products.values())) {
            if (product.getName().equals(name)) {
                list.add(product);
            }
        }
        return list;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
