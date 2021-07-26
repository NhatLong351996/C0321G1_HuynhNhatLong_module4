package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import com.codegym.model.service.BlogServicce;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogServicce blogServicce;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categorys")
    public Page<Category> categorys(Pageable pageable) {
        return categoryService.findAll(pageable);
    }


    @GetMapping("/list-blog")
    public ModelAndView getList(@PageableDefault(value = 2) Pageable pageable,
                                @RequestParam Optional<String> category,
                                @RequestParam Optional<String> search) {
        Page<Blog> blogs;
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        if (category.isPresent()) {
            Optional<Category> categoryOptional = categoryService.findAllByCategory(category.get());
            blogs = blogServicce.findAllByCategoryOrderByDatePublicationDesc
                    (categoryOptional.get(), pageable);
            modelAndView.addObject("search", category);
        } else if (search.isPresent()) {
            blogs = blogServicce.findAllByNameContaining(search.get(), pageable);
            modelAndView.addObject("search", search);
        } else {
            blogs = blogServicce.findAllByOrderByDatePublicationDesc(pageable);
        }
        modelAndView.addObject("blogList", blogs);
        return modelAndView;
    }


    @GetMapping("/create-blog")
    public ModelAndView getFormCreate() {
        return new ModelAndView("/blog/create",
                "blog", new Blog());
    }

    @PostMapping("/create-blog")
    public ModelAndView save(@ModelAttribute Blog blog) {
        blogServicce.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "Success!");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id) {
        return new ModelAndView("/blog/edit", "blog", blogServicce.findById(id).get());
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute Blog blog) {
        blogServicce.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Update success!");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView getFormDelete(@PathVariable Long id) {
        return new ModelAndView("/blog/delete", "blog", blogServicce.findById(id).get());
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute Blog blog) {
        blogServicce.remove(blog);
        return "redirect:/list-blog";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView getFormView(@PathVariable Long id) {
        return new ModelAndView("/blog/view", "blog", blogServicce.findById(id).get());
    }
}
