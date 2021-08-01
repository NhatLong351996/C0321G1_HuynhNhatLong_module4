package com.codegym.rest_controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.BlogServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    private BlogServicce blogServicce;

    @GetMapping
    public ResponseEntity<Page<Blog>> getAllBlog(@PageableDefault (value = 2)Pageable pageable) {
        Page<Blog> blogList = blogServicce.findAll(pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getOneBlog(@PathVariable Long id) {
        Optional<Blog> optionalBlog = blogServicce.findById(id);
        if (!optionalBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalBlog.get(), HttpStatus.OK);
    }

    @GetMapping("/blogs-category/{id}")
    public ResponseEntity<List<Blog>> getBlogsInCategory(@PathVariable Long id){
       List<Blog> blogList = blogServicce.findAllByCategory_Id(id);
       if (blogList==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(blogList,HttpStatus.OK);
    }

    @GetMapping("/loadMore/{page}")
    public ResponseEntity<Page<Blog>> loadMore(@PageableDefault(value = 3) Pageable pageable,
                                               @PathVariable Integer page) {
        Page<Blog> blogs = blogServicce.findAll(pageable.withPage(page));
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<Page<Blog>> search(@PathVariable String search,@PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogs = blogServicce.findAllByNameContaining(search,pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
