package com.codegym.controller;

import com.codegym.exception.NumberBookException;
import com.codegym.model.entity.Book;
import com.codegym.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;

    @GetMapping("/list-book")
    public ModelAndView getList(@PageableDefault(value = 5) Pageable pageable,
                                @RequestParam Optional<String> search)  {
        Page<Book> books;
        ModelAndView modelAndView = new ModelAndView("list");
        if (search.isPresent()) {
            books = iBookService.findAllByNameBookContaining(search.get(), pageable);
        }  else {
            books = iBookService.findAll(pageable);
        }
        modelAndView.addObject("key", search.orElse(null));
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView getFormInformation(@PathVariable Long id) {
        Optional<Book> book = iBookService.findById(id);
        return new ModelAndView("view", "book", book.get());
    }

    @PostMapping("/view")
    public ModelAndView borrow(@RequestParam Long idBorrow,
                               @PageableDefault Pageable pageable) throws NumberBookException {
        Optional<Book> book = iBookService.findById(idBorrow);
        Integer num = book.get().getNumberBook();
        Page<Book> books;
        if (num == 0) {
            throw new NumberBookException();
        }
        book.get().setNumberBook(num - 1);
        iBookService.save(book.get());
        books = iBookService.findAll(pageable);
        return new ModelAndView("list", "books", books);
    }

    @GetMapping("/return")
    public ModelAndView getFormReturn() {
        return new ModelAndView("return");
    }

    @PostMapping("/return")
    public ModelAndView returnBook(@RequestParam Optional<Long> idReturn,
                                   @PageableDefault Pageable pageable)
            throws NumberBookException {
        Page<Book> books;
        Optional<Book> book = iBookService.findById(idReturn.get());
        if (!book.isPresent()) {
            throw new NumberBookException();
        } else {
            Integer num = book.get().getNumberBook();
            book.get().setNumberBook(num + 1);
            iBookService.save(book.get());
            books = iBookService.findAll(pageable);
        }
        return new ModelAndView("list", "books", books);
    }

    @ExceptionHandler(NumberBookException.class)
    public String ErrorPage() {
        return "error";
    }

}
