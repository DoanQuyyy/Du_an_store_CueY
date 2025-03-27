package com.example.cueyshop.services;
import org.springframework.web.multipart.MultipartFile;
public interface StoreService {
    void store(MultipartFile file);
    void init();
}
