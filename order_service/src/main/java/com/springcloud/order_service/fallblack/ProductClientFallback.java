package com.springcloud.order_service.fallblack;
import com.springcloud.order_service.serviceClient.ProductClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;

/**
 * 针对商品服务做降级处理
 */
@Component  // 加入@Component 注解，表示这是一个组件，让spring扫描到
public class ProductClientFallback implements ProductClient {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String findById(Integer id) {
        // 配合redis。做全局变量。监控是否已经发出警告服务
        String serverNameKey="product-sercer";
        String sendValue=stringRedisTemplate.opsForValue().get(serverNameKey);
        // 重新开辟一个线程，专门用于监控服务，如果服务断开，用于提醒，可以连接短信服务或者邮件服务，
        new Thread(()->{
            if(StringUtils.isBlank(sendValue)){
                System.out.println("紧急通知，用户下单失败，请查找原因");
                stringRedisTemplate.opsForValue().set(serverNameKey,"product-sercer",200,TimeUnit.SECONDS);
            }else{
                System.out.println("已经发送过短信");
            }
        }).start();
        return null;
    }
}
