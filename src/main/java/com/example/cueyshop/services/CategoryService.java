package com.example.cueyshop.services;

import com.example.cueyshop.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category findById(int id);
    Boolean add(Category category);
    Boolean update(Category category);
    Boolean delete(int id);
}
