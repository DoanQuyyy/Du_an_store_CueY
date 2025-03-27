package com.example.cueyshop.services;

import com.example.cueyshop.model.Collectionn;
import java.util.List;


public interface CollectionService {
    List<Collectionn> getAllCollections();
    Collectionn findById(Integer id);
    Boolean add(Collectionn collectionn);
    Collectionn findbyName(String collectionnName);
}
