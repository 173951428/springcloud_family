package com.springcloud.product_service.mapper;

import org.springframework.stereotype.Repository;
import com.springcloud.product_service.entity.User;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> findList();

    User findById(Integer id);
}