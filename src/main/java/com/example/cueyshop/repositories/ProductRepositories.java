package com.example.cueyshop.repositories;

import com.example.cueyshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepositories extends JpaRepository<Product, Integer> {

//    @Query(value = "Select * From product p join categories c on p.Categories_ID = c.Categories_ID where c.Category_Name = :name ",nativeQuery = true)
//    List<Product> findByProduct(@Param("name")String name);
@Query("SELECT p FROM Product p WHERE p.Category.categoryName = :name")
List<Product> findByProduct(@Param("name") String name);

@Query("SELECT p FROM Product p WHERE p.collectionn.collectionName = :name")
List<Product> findByProductt(@Param("name") String name);
}
