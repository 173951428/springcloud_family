package com.springcloud.quartz_scheduling.JobDetail;
import com.springcloud.quartz_scheduling.entity.ProductOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.annotation.Resources;


@Component
public class JobDetailList {
    int count=1;
    int sum=1;

    @Autowired
    @Qualifier("productOrder1")
    private ProductOrder productOrder;
    private static Logger logger = LoggerFactory.getLogger(JobDetailList.class);

    /**
     * 第一个定时任务
     */
    public void firstJobDetail(){

        try {

            System.out.println("第1个定时任务启动:"+count+++"次，姓名:"+productOrder.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 第二个定时任务
     */
    public void secondJobDetail(){

        try {
            System.out.println("第2个定时任务启动:"+sum+++"次,交易单号:"+productOrder.getTradeNo());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
