package com.springcloud.product_service.mapper;

import com.springcloud.product_service.entity.Production;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionMapper {
    List<Production> findAll();

    Production findById(Integer id);
}
