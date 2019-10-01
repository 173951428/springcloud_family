package com.springcloud.quartz_scheduling.JobDetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JobDetailList {
    private static Logger logger = LoggerFactory.getLogger(JobDetailList.class);
    public void firstJobDetail(){
        logger.info("==> 定时任务启动");
        try {
            System.out.println("时间："+new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("==>定时任务结束");
    }


}
