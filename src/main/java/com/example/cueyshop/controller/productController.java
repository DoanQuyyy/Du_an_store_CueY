package com.example.cueyshop.controller;


import com.example.cueyshop.model.Category;
import com.example.cueyshop.model.Product;
import com.example.cueyshop.services.CategoryService;
import com.example.cueyshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class productController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/Product")
    public String product(Model model) {
        List<Product> list = this.productService.getAll();
        model.addAttribute("list", list);
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/Product/QLSP";
    }
    @PostMapping("/Product")
    public String save(@ModelAttribute("product") Product product) {
        if(this.productService.create(product)) {
            return "redirect:/admin/Product";
        }else{
            return "redirect:/admin/Product";
        }
    }
}
