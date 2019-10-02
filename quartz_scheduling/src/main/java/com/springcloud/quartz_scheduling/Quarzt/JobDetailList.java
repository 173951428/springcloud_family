package com.springcloud.quartz_scheduling.Quarzt;
import com.springcloud.quartz_scheduling.entity.Production;
import com.springcloud.quartz_scheduling.service.ProductionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JobDetailList {


    private static Logger logger = LoggerFactory.getLogger(JobDetailList.class);

   @Autowired
    ProductionService productionService;

    /**
     * 第一个定时任务
     */
    public void firstJobDetail(){

        try {

          Production p= productionService.findById(2);
            logger.info("------------------->>>>第1个定时任务启动，查找id为2的商品名为:"+p.getName()+"<-----------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 第二个定时任务
     */
    public void secondJobDetail(){

        try {

            Production p= productionService.findById(3);
            logger.info("------------------->>>>第2个定时任务启动完成，查找id为3的商品名为:"+p.getName()+"<-----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
