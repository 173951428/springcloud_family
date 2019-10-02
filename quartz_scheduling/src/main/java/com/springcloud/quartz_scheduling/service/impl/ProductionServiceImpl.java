package com.springcloud.quartz_scheduling.service.impl;

import com.springcloud.quartz_scheduling.entity.Production;
import com.springcloud.quartz_scheduling.mapper.ProductionMapper;
import com.springcloud.quartz_scheduling.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionServiceImpl implements ProductionService {
    @Autowired
    ProductionMapper mapper;
    @Override
    public Production findById(Integer id) {
        return mapper.findById(id);
    }
}
