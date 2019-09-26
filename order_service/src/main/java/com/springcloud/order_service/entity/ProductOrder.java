package com.springcloud.order_service.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
public class ProductOrder implements Serializable {

    private int id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品价格
     */
    private int price;
    /**
     * 订单流水号
     */
    private String tradeNo;
    private Date createTime;
    private int userId;
    private String userName;
}
