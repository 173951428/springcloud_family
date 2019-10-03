package com.springcloud.order_service.serviceClient;

import com.springcloud.order_service.fallblack.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 因为使用了Feign，所以需要定义一个接口，此接口为订单模块调用商品服务模块接口
 * name : 调用的服务名字
 * fallback: 调用异常以后的服务降级处理
 */
@FeignClient(name = "product-service",fallback = ProductClientFallback.class)
public interface ProductClient {
    @GetMapping("api/v1/product/findById") // product_service的需要调用的接口名字
    String findById(@RequestParam(value = "id") Integer id);
}
