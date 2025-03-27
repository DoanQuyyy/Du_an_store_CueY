package com.example.cueyshop.services;

import com.example.cueyshop.model.color;
import com.example.cueyshop.repositories.ColorRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ColorImpl implements ColorService {
    @Autowired
    private ColorRepositories colorRepositories;
    @Override
    public List<color> getAll() {
        return colorRepositories.findAll();
    }
    @Override
    public Boolean add(color colorr)
    {
        try {
            this.colorRepositories.save(colorr);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
