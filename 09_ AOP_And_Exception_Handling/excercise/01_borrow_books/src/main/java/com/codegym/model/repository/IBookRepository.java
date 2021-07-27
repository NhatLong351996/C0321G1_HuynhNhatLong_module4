package com.codegym.model.repository;

import com.codegym.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAllByNameBookContaining(String name, Pageable pageable);
}
