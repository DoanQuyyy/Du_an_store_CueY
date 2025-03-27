package com.example.cueyshop.services;

import com.example.cueyshop.model.Collectionn;
import com.example.cueyshop.repositories.CollectionRepositories;
import org.hibernate.engine.spi.CollectionEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionImpl implements CollectionService{
    @Autowired
    private CollectionRepositories collectionRepositories;
    @Override
    public List<Collectionn> getAllCollections()
    {
        return this.collectionRepositories.findAll();
    }
    @Override
    public Collectionn findById(Integer id){
        return this.collectionRepositories.findById(id).get();
    }
    @Override
    public Boolean add(Collectionn collectionn)
    {
        try{
            this.collectionRepositories.save(collectionn);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Collectionn findbyName(String name)
    {
        return this.collectionRepositories.findByCollectionNameCustom(name);
    }
}
