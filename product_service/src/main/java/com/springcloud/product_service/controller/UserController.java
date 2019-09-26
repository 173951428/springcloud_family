package com.springcloud.product_service.controller;

import com.springcloud.product_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.product_service.entity.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("findAll")
    public List<User> findAll() {
        return service.findList();
    }

    @RequestMapping("findById")
    public User findById(Integer id) {
        return service.findById(id);
    }
}
