package com.springcloud.product_service.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Production implements Serializable {

    private Integer id; // id
    private String name; //名字
    private Integer price;// 价格
    private Integer store;// 库存
}
