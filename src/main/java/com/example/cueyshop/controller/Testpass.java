package com.example.cueyshop.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Testpass {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("12345678"));
    }

}
