package com.example.cueyshop.services;


import com.example.cueyshop.model.color;

import java.util.List;

public interface ColorService {
    List<color> getAll();
    Boolean add(color color);
}
