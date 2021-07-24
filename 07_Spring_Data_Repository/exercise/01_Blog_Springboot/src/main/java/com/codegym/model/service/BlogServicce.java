package com.codegym.model.service;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogServicce {
    void save(Blog blog);

    Optional<Blog> findById(Long id);

    void remove(Blog blog);

    Page<Blog> findAllByCategoryOrderByDatePublicationDesc(Category category,Pageable pageable);
    Page<Blog> findAllByOrderByDatePublicationDesc(Pageable pageable);
}