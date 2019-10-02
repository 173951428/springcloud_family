package com.springcloud.quartz_scheduling.service;

import com.springcloud.quartz_scheduling.entity.Production;

public interface ProductionService {

    Production findById(Integer id);
}
