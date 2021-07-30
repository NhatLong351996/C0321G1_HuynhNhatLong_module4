package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findAllByCategoryOrderByDatePublicationDesc(Category category,Pageable pageable);
    Page<Blog> findAllByOrderByDatePublicationDesc(Pageable pageable);
    Page<Blog> findAllByNameContaining(String name,Pageable pageable);
    Page<Blog> findAllByCategory_Id(Long id,Pageable pageable);
    List<Blog> findAllByCategory_Id(Long id);
}
