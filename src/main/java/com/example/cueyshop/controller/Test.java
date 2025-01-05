package com.example.cueyshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Test {
    @GetMapping
    public String test() {
        return "redirect:/admin/";
    }
    @RequestMapping("/")
    public String admin() {

        return "admin/GioiThieu.html";
    }
}
