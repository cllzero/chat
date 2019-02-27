package com.example.demo.Repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface  UserRepository extends JpaRepository<User,Integer>{
    public User findByUsername(String username);
}
