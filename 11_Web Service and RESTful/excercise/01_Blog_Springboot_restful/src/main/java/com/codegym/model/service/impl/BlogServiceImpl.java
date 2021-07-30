package com.codegym.model.service.impl;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.repository.BlogRepository;
import com.codegym.model.service.BlogServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogServicce {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }


    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findAllByCategoryOrderByDatePublicationDesc(Category category, Pageable pageable) {
        return blogRepository.findAllByCategoryOrderByDatePublicationDesc(category,pageable);
    }


    @Override
    public Page<Blog> findAllByOrderByDatePublicationDesc(Pageable pageable) {
        return blogRepository.findAllByOrderByDatePublicationDesc(pageable);
    }

    @Override
    public Page<Blog> findAllByNameContaining(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Blog> findAllByCategory_Id(Long id, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(id,pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByCategory_Id(Long id) {
        return blogRepository.findAllByCategory_Id(id);
    }


}
