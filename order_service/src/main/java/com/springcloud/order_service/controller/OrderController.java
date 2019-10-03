package com.springcloud.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.order_service.entity.ProductOrder;
import com.springcloud.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


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
    @HystrixCommand(fallbackMethod = "saveOrderFail") // 在最外层调用方法里面增加该方法调用失败的方法，用作服务熔断保护。
    public Map<String,Object> save(@RequestParam("productId") int productId){
        ProductOrder productOrder=productOrderService.save(productId);
        System.out.println("调用订单接口成功");
        Map<String,Object> result=new HashMap<>();
        result.put("code",200);
        result.put("data",productOrder);
        return  result;
    }

    /**
     * 添加熔断方法，注意方法的返回值和方法参数一定要和被熔断的方法save(userId,productId)保持一致
     * 订单接口调用产品服务接口，如果产品接口挂机了，查询不出来数据，则走此方法，进行熔断保护，自定义返回数据给前端
     * @param userId
     * @return
     */
    private Map<String,Object> saveOrderFail(int userId){
        Map<String,Object> result=new HashMap<>();
        result.put("code",500);
        result.put("data","服务熔断保护");
        return  result;

    }
}
