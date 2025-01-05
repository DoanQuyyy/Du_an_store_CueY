package com.example.cueyshop.services;

import com.example.cueyshop.model.Product;
import com.example.cueyshop.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepositories productRepositories;
    @Override
    public List<Product> getAll() {
        return this.productRepositories.findAll();
    }

    @Override
    public Boolean create(Product product) {
        try {
            this.productRepositories.save(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Product findById(Integer id) {
        return this.productRepositories.findById(id).get();
    }
    @Override
    public Boolean update(Product product) {
        return false;
    }
    @Override
    public Boolean delete(int id){
        return false;
    }

}
