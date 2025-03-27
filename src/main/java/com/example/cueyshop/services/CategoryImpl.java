package com.example.cueyshop.services;

import com.example.cueyshop.model.Category;
import com.example.cueyshop.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryRepositories categoryRepositories;
    @Override
    public List<Category> getAll() {
        return this.categoryRepositories.findAll();
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepositories.findById(id).get();
    }

    @Override
    public Boolean add(Category category) {
        try {
            this.categoryRepositories.save(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(Category category) {
        try {
            this.categoryRepositories.save(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Category category) {
        try {
            this.categoryRepositories.delete(category);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
