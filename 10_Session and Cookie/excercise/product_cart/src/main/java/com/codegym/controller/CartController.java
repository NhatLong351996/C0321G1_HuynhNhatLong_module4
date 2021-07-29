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
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView showCart(@SessionAttribute(name = "cart", required = false) CartDto cart) {
        return new ModelAndView("cart/viewCart", "cart", cart);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id,
                                      @SessionAttribute CartDto cart,
                                      RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productOptional.get(), productDto);
        cart.delete(productDto);
        redirectAttributes.addFlashAttribute("message","Delete"+ productDto.getName()+" success!");
        return new ModelAndView("redirect:/cart");
    }
}
