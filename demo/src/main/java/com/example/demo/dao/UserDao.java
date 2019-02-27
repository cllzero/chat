package com.example.demo.dao;

import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.Serializable;
import java.rmi.MarshalledObject;
import java.util.List;
import java.util.Map;

@Repository("CommonDao")
public class UserDao implements CommonDao{
    @Autowired CommonDao commonDao;

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public List<User> save(String username) {
        return null;
    }
}
