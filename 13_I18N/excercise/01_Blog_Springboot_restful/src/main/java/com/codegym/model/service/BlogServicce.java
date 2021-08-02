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

    Page<Blog> findAllByCategory_CategoryOrderByDatePublicationDesc(String category,Pageable pageable);
    Page<Blog> findAllByOrderByDatePublicationDesc(Pageable pageable);
    Page<Blog> findAllByNameContaining(String name,Pageable pageable);
    Page<Blog> findAllByCategory_Id(Long id,Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAllByCategory_Id(Long id);
}
