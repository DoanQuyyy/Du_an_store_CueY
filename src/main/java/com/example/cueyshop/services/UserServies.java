package com.example.cueyshop.services;

import com.example.cueyshop.model.User;

import java.util.List;

public interface UserServies {
    User findByName(String name);

    List<User> getUser();
}
