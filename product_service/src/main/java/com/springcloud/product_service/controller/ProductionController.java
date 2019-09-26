package com.springcloud.product_service.controller;

import com.springcloud.product_service.entity.Production;
import com.springcloud.product_service.service.ProductionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductionController {
    // 注入应用启动的端口号
    @Value("${server.port}")
    private String port;

    @Autowired
    ProductionService service;

    /**
     * 查询全部商品
     *
     * @return
     */
    @RequestMapping("list")
    public List<Production> list() {

        return service.findAll();
    }

    /**
     * 根据商品id返回商品信息
     *
     * @param id
     * @return
     */
    @RequestMapping("findById")
    public Production findById(Integer id) {
        Production production = service.findById(id);
        Production result = new Production();
        BeanUtils.copyProperties(production, result);
        result.setName(result.getName() + "data from =" + port);
        return result;
    }
}
