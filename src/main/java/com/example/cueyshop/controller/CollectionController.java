package com.example.cueyshop.controller;


import com.example.cueyshop.model.Collectionn;
import com.example.cueyshop.model.Product;
import com.example.cueyshop.services.CategoryService;
import com.example.cueyshop.services.CollectionService;
import com.example.cueyshop.services.ProductService;
import com.example.cueyshop.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CollectionController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private ProductService productService;
    @GetMapping("/bosuutap")
    public String ProController(Model model) {
        List<Collectionn> collectionnList = this.collectionService.getAllCollections();
        model.addAttribute("collectionnList", collectionnList);
        return "admin/Bosuutap";
    }
    @GetMapping("/bosuutap/add-BST")
    public String addBST(Model model) {
        Collectionn cln = new Collectionn();
        model.addAttribute("collection", cln);
        return "admin/add_BST";
    }
    @PostMapping("/bosuutap/add-BST")
    public String save(@ModelAttribute("collection") Collectionn cln,@RequestParam("file") MultipartFile file) {
        this.storeService.store(file);
        String fileName = file.getOriginalFilename();
        cln.setImage(fileName);
        if(this.collectionService.add(cln))
        {
            return "redirect:/admin/bosuutap";
        }else{
            return "/admin/bosuutap";
        }
    }
    @GetMapping("/bosuutap/{collectionName}")
    public String show(@PathVariable("collectionName") String collectionName, Model model) {
        Collectionn collectionn = this.collectionService.findbyName(collectionName);
        model.addAttribute("collection", collectionn);
        List<Product> pd = this.productService.findByProductt(collectionName);
        model.addAttribute("pd", pd);
        return "public/Item_bst";
    }

}
