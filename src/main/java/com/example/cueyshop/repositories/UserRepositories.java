package com.example.cueyshop.repositories;

import com.example.cueyshop.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepositories extends JpaRepository<User, Integer> {
    User findByName(String name);
}
