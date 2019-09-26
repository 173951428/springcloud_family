package com.springcloud.order_service.controller;

import com.springcloud.order_service.entity.ProductOrder;
import com.springcloud.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    @Autowired
    private ProductOrderService productOrderService;
    /**
     * 用户下单接口
     * TODO
     */
    @RequestMapping("save")
    public ProductOrder save(@RequestParam("userId") int userId,@RequestParam("productId") int productId){
        ProductOrder ProductOrder=productOrderService.save(userId,productId);
        System.out.println("调用订单接口成功");
        return  ProductOrder;

    }
}
