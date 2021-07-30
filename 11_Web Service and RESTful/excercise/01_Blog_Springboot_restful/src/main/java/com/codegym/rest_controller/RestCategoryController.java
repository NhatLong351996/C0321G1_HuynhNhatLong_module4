package com.codegym.rest_controller;

import com.codegym.model.bean.Category;
import com.codegym.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class RestCategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/page")
    public ResponseEntity<Page<Category>> getListCategory(@PageableDefault Pageable pageable){
       Page<Category> categories = categoryService.findAll(pageable);
       if (categories.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
}
