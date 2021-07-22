package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.BlogServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    BlogServicce blogServicce;

    @GetMapping("/list-blog")
    public ModelAndView getList() {
        return new ModelAndView("blog/list", "blogList", blogServicce.findAll());
    }

    @GetMapping("/create-blog")
    public ModelAndView getFormCreate() {
        return new ModelAndView("blog/create", "blog", new Blog());
    }

    @PostMapping("/create-blog")
    public ModelAndView save(@ModelAttribute Blog blog) {
        blogServicce.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "Success!");
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id) {
        return new ModelAndView("blog/edit", "blog", blogServicce.findById(id));
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute Blog blog) {
        blogServicce.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Update success!");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView getFormDelete(@PathVariable Long id) {
        return new ModelAndView("blog/delete", "blog", blogServicce.findById(id));
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute Blog blog) {
        blogServicce.remove(blog);
        return "redirect:/list-blog";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView getFormView(@PathVariable Long id) {
        return new ModelAndView("blog/view", "blog", blogServicce.findById(id));
    }
}
