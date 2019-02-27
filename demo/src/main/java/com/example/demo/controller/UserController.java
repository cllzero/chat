package com.example.demo.controller;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
//获取用户列表
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository ;

    @RequestMapping(value = "/chaxun")
    public List<User>userList(){
        return userRepository.findAll();
    }

    //头像上传


}
