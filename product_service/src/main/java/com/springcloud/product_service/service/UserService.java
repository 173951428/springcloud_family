package com.springcloud.product_service.service;

import com.springcloud.product_service.entity.User;

import java.util.List;

public interface UserService {
    List<User> findList();

    User findById(Integer id);

}
