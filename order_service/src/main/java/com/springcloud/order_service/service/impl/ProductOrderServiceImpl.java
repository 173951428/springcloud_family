package com.springcloud.order_service.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.springcloud.order_service.entity.ProductOrder;
import com.springcloud.order_service.service.ProductOrderService;
import com.springcloud.order_service.serviceClient.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    // 不同的rest 调用方式
    /* @Autowired
       RestTemplate restTemplate;

       private LoadBalancerClient loadBalancer;
    */

    @Autowired
    private ProductClient productClient;

    @Override
    public ProductOrder save(int productId) {
        String response=  productClient.findById(productId);
        // alibaba fastJson 字符转对象
        ProductOrder productOrder=  JSONObject.parseObject(response, ProductOrder.class);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(2);
        return  productOrder;
    }
/*
    @Override
    public ProductOrder save(int userId) {
        // rest 接口调用风格，调用商品服务的接口,
       // Map<String, Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/findById?id=" + productId, Map.class);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        //productOrder.setProductName(productMap.get("name").toString());
      //  productOrder.setPrice(Integer.parseInt(productMap.get("price").toString()));
        return productOrder;
    }*/
}
