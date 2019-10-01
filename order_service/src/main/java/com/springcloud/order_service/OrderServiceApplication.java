package com.springcloud.order_service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//-----------------注解太多---------------
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients  // 因为这个订单服务调用产品服务，所以订单服务要集成FenignClients
@EnableCircuitBreaker // Feign结合Hystrix断路器开发
//---------------------------------------
// 注解太多，一个启动类@SpringCloudApplication 注解全部搞定
//@SpringCloudApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    /**
     * 方式一: 启动类加上ribbon
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
