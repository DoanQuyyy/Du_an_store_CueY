package com.example.cueyshop.controller;

import com.example.cueyshop.model.color;
import com.example.cueyshop.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ColorController {
    @Autowired
    private ColorService colorService;
    @GetMapping("/color")
    public String cloController(Model model)
    {
        List<color> colors = colorService.getAll();
        model.addAttribute("colors", colors);
        return "admin/Color/Color";
    }
    @GetMapping("color/add")
    public String add_color(Model model)
    {
        color color = new color();
        model.addAttribute("color", color);
        return "admin/Color/add_color";
    }
    @PostMapping("color/add")
    public String add_color(@ModelAttribute("color") color clr)
    {
        if(this.colorService.add(clr))
        {
            return "redirect:/admin/color";
        }
        return "admin/color";
    }
}
