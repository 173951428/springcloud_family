package com.springcloud.product_service.service.impl;

import com.springcloud.product_service.entity.Production;
import com.springcloud.product_service.mapper.ProductionMapper;
import com.springcloud.product_service.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionImpl implements ProductionService {
    @Autowired
    ProductionMapper mapper;

    @Override
    public List<Production> findAll() {
        return mapper.findAll();
    }

    @Override
    public Production findById(Integer id) {
        return mapper.findById(id);
    }
}
