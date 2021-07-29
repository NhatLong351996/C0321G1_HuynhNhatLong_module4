package com.codegym.controller;

import com.codegym.dto.CartDto;
import com.codegym.dto.ProductDto;
import com.codegym.model.entity.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {
@ModelAttribute("cart")
public CartDto initCart(){
    return new CartDto();
}
    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView showListPage(){
        return new ModelAndView("product/list","productList",productService.findAll());
    }

    @GetMapping("add/{id}")
    public ModelAndView addToCart(@PathVariable Long id,
                                  @SessionAttribute CartDto cart,
                                  RedirectAttributes redirectAttributes){
       Optional<Product> productEntity = productService.findById(id);
       if (!productEntity.isPresent()){
           return new ModelAndView("error");
       }
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productEntity.get(),productDto);
        cart.addProductDtoIntoSession(productDto);
        redirectAttributes.addFlashAttribute("success", "Add "
                +cart.getProductDtoIntegerMap().get(productDto)+" product name: "
                +productDto.getName()+" Thank you!");
        return new ModelAndView("redirect:/shop");
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showViewProduct(@PathVariable Long id){
return new ModelAndView("product/detail","product",productService.findById(id).get());
    }

}
