package com.example.cueyshop.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class FileSystemStoreService implements StoreService {
    private final Path root ;

    public FileSystemStoreService() {
        this.root = Paths.get("src/main/resources/static/Image");
    }
    @Override
    public void store(MultipartFile file) {
        try {
            Path destination = this.root.resolve(Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
            try(InputStream in = file.getInputStream()) {
                Files.copy(in,destination, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void init(){
        try {
            Files.createDirectories(root);
        } catch (IOException e) {

        }
    }

}
