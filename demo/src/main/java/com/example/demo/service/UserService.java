package com.example.demo.service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.dao.UserDao;
import com.example.demo.entities.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.beans.Transient;

@Service
public class UserService {
    @Resource
    UserDao userDao;
    @Resource
    UserRepository userRepository;
    //保存用户数据
    @Transactional
    public void save(User User){
        userRepository.save(User);
    }
    //删除用户数据
   @Transactional

    //查询数据
    public Iterable<User>getall(){
        return userRepository.findAll();
    }
    //修改用户数据

}
