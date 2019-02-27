package com.example.demo.config;

import com.example.demo.component.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.nio.channels.MulticastChannel;

@Configuration
public class HelloConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/Homepage.html").setViewName("Homepage");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/repassword.html").setViewName("repassword");
        registry.addViewController("/xieyi.html").setViewName("xieyi");

    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/login","","/xieyi","/","/login/","/register","/register.html","/css/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}

