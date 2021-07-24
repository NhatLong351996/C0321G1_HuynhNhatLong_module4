package com.codegym.model.service;

import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface CategoryService {
    void save(Category category);

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long id);

    void remove(Category category);
    Optional<Category> findAllByCategory(String category);
}
