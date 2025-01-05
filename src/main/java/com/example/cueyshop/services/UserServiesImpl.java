package com.example.cueyshop.services;

import com.example.cueyshop.model.User;
import com.example.cueyshop.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiesImpl implements UserServies {
    @Autowired
    private UserRepositories userRepositories;
    @Override
    public User findByName(String name) {
        return userRepositories.findByName(name);
    }
    @Override
    public List<User> getUser() {
        return userRepositories.findAll();  // Lấy tất cả người dùng từ database
    }
}
