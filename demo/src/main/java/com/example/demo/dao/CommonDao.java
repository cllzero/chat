package com.example.demo.dao;

import com.example.demo.entities.User;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface CommonDao {
    //通过username查询
    public User findByUsername(String username);

    //
    public List<User> save(String username);
}
