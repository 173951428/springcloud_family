package com.springcloud.quartz_scheduling.mapper;

import com.springcloud.quartz_scheduling.entity.Production;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionMapper {

    Production findById(Integer id);
}
