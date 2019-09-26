package com.springcloud.order_service.service.impl;
import com.springcloud.order_service.entity.ProductOrder;
import com.springcloud.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    RestTemplate restTemplate;

    //private LoadBalancerClient loadBalancer;

    @Override
    public ProductOrder save(int userId, int productId) {
        // rest 接口调用风格，调用商品服务的接口,
        Map<String, Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/findById?id=" + productId, Map.class);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(productMap.get("name").toString());
        productOrder.setPrice(Integer.parseInt(productMap.get("price").toString()));
        return productOrder;
    }
}
