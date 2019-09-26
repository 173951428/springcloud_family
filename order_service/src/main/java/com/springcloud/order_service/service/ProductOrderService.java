package com.springcloud.order_service.service;

import com.springcloud.order_service.entity.ProductOrder;

/**
 * 订单服务接口
 */
public interface ProductOrderService {

    /**
     * 下单接口
     * @param userId 用户id
     * @param productId 商品id
     * @return
     */
    ProductOrder save(int userId,int productId);

}
