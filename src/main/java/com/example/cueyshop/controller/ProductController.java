package com.example.cueyshop.controller;

import com.example.cueyshop.model.Category;
import com.example.cueyshop.model.Product;
import com.example.cueyshop.model.color;
import com.example.cueyshop.services.CategoryService;
import com.example.cueyshop.services.ColorService;
import com.example.cueyshop.services.ProductService;
import com.example.cueyshop.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StoreService storeService;
    @GetMapping("/Product")
    public String ProController(Model model) {
        List<Product> products = this.productService.getAll();
        model.addAttribute("products", products);
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/Product/SanPham";
    }
    @GetMapping("Product/addProduct")
    public String addPro(Model model) {
        List<color> listcolor = this.colorService.getAll();
        model.addAttribute("color",listcolor);
        List<Category> categoryList = this.categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/Product/add_Product";
    }
    @PostMapping("Product/addProduct")
    public String save(@ModelAttribute("product") Product product ,@RequestParam("file") MultipartFile file ) {
        this.storeService.store(file);
        String fileName = file.getOriginalFilename();
        product.setImage(fileName);
        if(this.productService.create(product)) {
            return "redirect:/admin/Product";
        }else{
            return "redirect:/admin/Product";
        }
    }
    @GetMapping("Product/EditProduct/{id}")
    public String editPro(Model model ,@PathVariable("id") int id) {
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "admin/Product/edit_Product";
    }
    @GetMapping("Product/DeleteProduct")
    public String delete(@RequestParam int id) {
        try {
            Product product = this.productService.findById(id);
            this.productService.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/Product";
    }
}
