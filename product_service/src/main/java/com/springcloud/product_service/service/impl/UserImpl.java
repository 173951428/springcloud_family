package com.springcloud.product_service.service.impl;

import com.springcloud.product_service.mapper.UserMapper;
import com.springcloud.product_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springcloud.product_service.entity.*;

import java.util.List;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserMapper mapper;

    @Override
    public List<User> findList() {
        return mapper.findList();
    }

    @Override
    public User findById(Integer id) {
        return mapper.findById(id);
    }
}
