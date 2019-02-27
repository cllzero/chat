package com.example.demo.controller;

import com.example.demo.Repository.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.apache.tomcat.jni.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;


@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Resource
    UserService userService;

    //登陆
    @GetMapping(value = "/login")
    public String login(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if (userRepository.findByUsername(username)!= null){
            if (userRepository.findByUsername(username).getPassword().equals(password)
            ) {
                session.setAttribute("loginuser", username);
                //登陆成功
                return "index";
            } else {
                //登陆失败
                map.put("msg", "账号或密码错误！");
                return "login";
            }
        }else{
            map.put("msg", "账号或密码错误！");
           return "login";
        }
    }

    //注册
    @GetMapping(value = "/register")
    public String adduser(@RequestParam(value = "username", required = false) String username,
                          @RequestParam(value = "password", required = false) String password,
                          Map<String, Object> map) {
        if ((userRepository.findByUsername(username) == null)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.save(user);
            //注册成功前往聊天室
            return "index";
        } else {
            //用户名已经注册
            map.put("msg", "用户名已经注册");
            return "register";
        }
    }

    //头像上传
    @PostMapping(value = "/upload")
    public String singlefileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "please select a file ");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message", "success" + file.getOriginalFilename());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //return "redirect:/uploadStatus";
        return "index";
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(MultipartException.class)
        public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
            redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
            return "redirect:/uploadStatus";
        }
    }

    //个人资料更新

    @PostMapping(value = "/zlupdate")
    public String zlupdate(){
        return null;
    }
}





