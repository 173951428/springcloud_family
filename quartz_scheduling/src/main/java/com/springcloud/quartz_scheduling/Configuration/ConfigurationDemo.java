package com.springcloud.quartz_scheduling.Configuration;

import com.springcloud.quartz_scheduling.entity.ProductOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationDemo {
    @Bean("productOrder1")
    public ProductOrder getProductOrder(){
        ProductOrder productOrder=new ProductOrder();
        productOrder.setName("zxp");
        productOrder.setTradeNo("交易单号10010");
        return productOrder;
    }
}
