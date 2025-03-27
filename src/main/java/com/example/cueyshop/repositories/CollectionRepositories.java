package com.example.cueyshop.repositories;

import com.example.cueyshop.model.Collectionn;
import com.example.cueyshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollectionRepositories extends JpaRepository<Collectionn, Integer> {
    @Query("SELECT c FROM Collectionn c WHERE c.collectionName = :name")
    Collectionn findByCollectionNameCustom(@Param("name") String name);
}
