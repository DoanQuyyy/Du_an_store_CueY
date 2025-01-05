package com.example.cueyshop.services;

import com.example.cueyshop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product findById(Integer id);
    Boolean create(Product product);
    Boolean update(Product product);
    Boolean delete(int id);


}
