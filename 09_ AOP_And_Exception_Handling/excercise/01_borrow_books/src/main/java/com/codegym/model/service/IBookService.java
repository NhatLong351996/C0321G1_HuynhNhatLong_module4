package com.codegym.model.service;

import com.codegym.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    Page<Book> findAllByNameBookContaining(String name,Pageable pageable);
    Optional<Book> findById(Long id);
    void save(Book book);
    }
