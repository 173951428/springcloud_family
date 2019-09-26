package com.springcloud.product_service.service;

import com.springcloud.product_service.entity.Production;

import java.util.List;

public interface ProductionService {
    List<Production> findAll();

    Production findById(Integer id);
}
