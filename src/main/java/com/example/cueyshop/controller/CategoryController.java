package com.example.cueyshop.controller;

import com.example.cueyshop.model.Category;
import com.example.cueyshop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("Category/TheLoai")
    public String CateController(Model model) {
        List<Category> categoryList = this.categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/Category/TheLoai";
    }

    @GetMapping("Category/addCategory")
    public String add(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/Category/addCategory";
    }
    @PostMapping("Category/addCategory")
    public String save(@ModelAttribute("category") Category category) {
        if(this.categoryService.add(category)) {
            return "redirect:/admin/Category/TheLoai";
        }else{
            return "admin/Category/TheLoai";
        }
    }
    @GetMapping("Category/EditCategory/{id}")
    public String Edit(Model model ,@PathVariable("id") int id) {
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/Category/edit_Category";
    }
    @PostMapping("Category/EditCategory")
    public String update(@ModelAttribute("category") Category category) {
        if(this.categoryService.update(category)) {
            return "redirect:/admin/Category/TheLoai";
        }else{
            return "admin/Category/TheLoai";
        }
    }
    @GetMapping("Category/DeleteCategory")
    public String delete(@RequestParam int id) {
        try {
            Category category = this.categoryService.findById(id);
            this.categoryService.delete(category);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/Category/TheLoai";
    }

}
