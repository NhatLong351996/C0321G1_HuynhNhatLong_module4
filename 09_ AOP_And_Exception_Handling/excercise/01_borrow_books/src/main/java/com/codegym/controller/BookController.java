package com.codegym.controller;

import com.codegym.exception.NumberBookException;
import com.codegym.model.entity.Book;
import com.codegym.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;

    @GetMapping("/list-book")
    public ModelAndView getList(@PageableDefault(value = 5) Pageable pageable,
                                @RequestParam Optional<String> s,
                                @RequestParam Optional<Long> id,
                                @RequestParam Optional<Long> idReturn) throws NumberBookException {
        Page<Book> books;
        ModelAndView modelAndView = new ModelAndView("list");
        if (idReturn.isPresent()) {
            Optional<Book> book = iBookService.findById(idReturn.get());
            if (book.get()==null){
                throw new NumberBookException();
            }else {
                Integer num = book.get().getNumberBook();
                book.get().setNumberBook(num - 1);
                iBookService.save(book.get());
                books = iBookService.findAll(pageable);
            }
        } else if (s.isPresent()) {
            books = iBookService.findAllByNameBookContaining(s.get(), pageable);
        } else if (id.isPresent()) {
            Optional<Book> book = iBookService.findById(id.get());
            Integer num = book.get().getNumberBook();
            if (num == 0) {
                throw new NumberBookException();
            }
            book.get().setNumberBook(num - 1);
            iBookService.save(book.get());
            books = iBookService.findAll(pageable);
        } else {
            books = iBookService.findAll(pageable);
        }
        modelAndView.addObject("key", s.orElse(null));
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView getFormInformation(@PathVariable Long id) {
        Optional<Book> book = iBookService.findById(id);
        return new ModelAndView("view", "book", book.get());
    }

    @GetMapping("/return")
    private ModelAndView getFormReturn() {
        return new ModelAndView("return");
    }

    @ExceptionHandler(NumberBookException.class)
    public String getErrorPage() {
        return "error";
    }

}
