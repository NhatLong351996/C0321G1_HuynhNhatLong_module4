package com.codegym.model.service.impl;

import com.codegym.model.bean.Category;
import com.codegym.model.repository.CategoryRepository;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void remove(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Optional<Category> findAllByCategory(String category) {
        return categoryRepository.findAllByCategory(category);
    }
}
