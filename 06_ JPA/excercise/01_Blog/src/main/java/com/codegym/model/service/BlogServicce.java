package com.codegym.model.service;

import com.codegym.model.bean.Blog;

import java.util.List;

public interface BlogServicce {
    void save(Blog blog);
    List<Blog> findAll();
    Blog findById(Long id);
    void remove(Blog blog);
}
