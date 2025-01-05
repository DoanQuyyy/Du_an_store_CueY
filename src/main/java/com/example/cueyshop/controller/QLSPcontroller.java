package com.example.cueyshop.controller;

import com.example.cueyshop.model.Category;
import com.example.cueyshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class QLSPcontroller {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/QLSPham")
    public String QLNV(Model model) {
        List<Category> list = this.categoryService.getAll();
        model.addAttribute("list", list);
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/Product/QLSP";
    }
    @PostMapping("/QLSPham")
    public String save(@ModelAttribute("category") Category category) {
        if(this.categoryService.add(category)) {
            return "redirect:/admin/QLSPham";
        }else{
            return "redirect:/admin/QLSPham";
        }
    }
}