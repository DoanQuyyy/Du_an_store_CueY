package com.example.cueyshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ColorImpl implements ColorService {
    @Autowired
    private ColorService colorService;
    @Override
    public List<Color> getAll() {
        return colorService.getAll();
    }
    

}
