package com.example.cueyshop.repositories;

import com.example.cueyshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositories extends JpaRepository<Product, Integer> {

}
