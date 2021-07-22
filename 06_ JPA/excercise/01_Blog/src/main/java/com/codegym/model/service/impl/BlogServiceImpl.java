package com.codegym.model.service.impl;

import com.codegym.model.bean.Blog;
import com.codegym.model.repository.BlogRepository;
import com.codegym.model.service.BlogServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogServicce {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).get();
    }


    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }
}
