package com.codegym.model.repository;

import com.codegym.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findAllByCategory(String category);
}
