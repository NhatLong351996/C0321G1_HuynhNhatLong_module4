package com.codegym.controller;

import com.codegym.model.bean.Category;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list-category")
    public ModelAndView getListCategory(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("/category/list", "categoryList",
                categoryService.findAll(pageable));
    }

    @GetMapping("/create-category")
    public ModelAndView getFormCreate() {
        return new ModelAndView("/category/create", "categoryNew", new Category());
    }

    @PostMapping("/create-category")
    public ModelAndView saveNewCategory(@ModelAttribute("categoryNew") Category categoryNew) {
        categoryService.save(categoryNew);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("categoryNew", new Category());
        modelAndView.addObject("message", "Create Success!");
        return modelAndView;
    }
    @GetMapping("/edit-category/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        return new ModelAndView("/category/edit","categoryOld",category.get());
    }
    @PostMapping("/edit-category")
    public ModelAndView saveOldCategory(@ModelAttribute("categoryOld") Category categoryOld){
        categoryService.save(categoryOld);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("categoryOld",categoryOld);
        modelAndView.addObject("message","Edit Success!");
        return modelAndView;
    }
    @GetMapping("/delete-category/{id}")
    public ModelAndView getFormDelete(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        return new ModelAndView("/category/delete","categoryOld",category.get());
    }
    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute Category categoryOld, Model model){
        categoryService.remove(categoryOld);
        model.addAttribute("message","Delete Success!");
        return "redirect:/list-category";
    }
    @GetMapping("/view-category/{id}")
    public ModelAndView getFormView(@PathVariable Long id){
        return new ModelAndView("/category/view","categoryOld",categoryService.findById(id).get());
    }

}
