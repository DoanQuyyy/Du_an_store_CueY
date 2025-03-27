package com.example.cueyshop.controller;


import com.example.cueyshop.model.Category;
import com.example.cueyshop.model.Collectionn;
import com.example.cueyshop.model.Product;
import com.example.cueyshop.services.CategoryService;
import com.example.cueyshop.services.CollectionService;
import com.example.cueyshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/CueYShop")
public class TrangChuController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CollectionService collectionService;
    @GetMapping
    public String test(Model model) {
        List<Category> categoryList = this.categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        List<Collectionn> collectionnList = this.collectionService.getAllCollections();
        model.addAttribute("collectionnList", collectionnList);
        return "public/index";
    }
    @GetMapping("/BoSuuTap")
    public String BoSuuTap(Model model) {
        List<Product> products = this.productService.getAll();
        model.addAttribute("products", products);
        List<Category> categoryList = this.categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "public/Item_bst";
    }
    @GetMapping("/TheLoai/{name}")
    public String TheLoai(Model model ,@PathVariable("name") String name) {
        List<Product> pd = this.productService.findByProduct(name);
        model.addAttribute("pd", pd);
        List<Category> categoryList = this.categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "public/Item_theloai";
    }


}
