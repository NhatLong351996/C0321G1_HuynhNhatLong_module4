package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import com.codegym.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    IProductService productService = new ProductService();
@GetMapping("")
    public String index(Model model){
    model.addAttribute("products",productService.findAll());
    return "index";
}
@GetMapping("/create")
    public String create(Model model){
    model.addAttribute("product",new Product());
    return "create";
}
@PostMapping("/save")
    public String save(Product product, RedirectAttributes attributes){
    product.setId((int) (Math.random()*10000));
    productService.save(product);
    attributes.addFlashAttribute("success","Your product"+product.getName()+"save success!");
    return "redirect:/product";
}
@GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
    model.addAttribute("product",productService.findById(id));
    return "edit";
}
@PostMapping("/update")
public String update(RedirectAttributes attributes,Product product){
    productService.update(product.getId(),product);
    attributes.addFlashAttribute("success","Update success!");
    return "redirect:/product";
}
@GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
    model.addAttribute("product",productService.findById(id));
    return "delete";
}
@PostMapping("/delete")
    public String delete(Product product, RedirectAttributes attributes){
    attributes.addFlashAttribute("success","Delete success!");
    productService.remove(product.getId());
    return "redirect:/product";
}
@GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
    model.addAttribute("product",productService.findById(id));
    return "view";
}
@GetMapping("/findbyname")
    public String findByName(){
    return "findbyname";
}
@PostMapping("/find")
    public String viewFindByName(@RequestParam String name,Model model){
    List<Product> products = productService.findByName(name);
    if (products.isEmpty()){
        model.addAttribute("message","Not found!");
        return "findbyname";
    }
    model.addAttribute("products",products);
    return "index";
}
}
