package com.springcloud.quartz_scheduling.Quarzt;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfiguration {


    // 配置定时任务1
    @Bean(name = "firstJobDetail")
    public MethodInvokingJobDetailFactoryBean firstJobDetail(JobDetail task){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(false);

        // 设置任务的名字
        jobDetail.setName("firstJobDetail");

        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("firstJobDetailJobGroup");

        // 需要执行的对象
        jobDetail.setTargetObject(task);
        /*
         * TODO 非常重要 执行QuartzTask类中的需要执行方法
         */
        jobDetail.setTargetMethod("firstJobDetail");

        return jobDetail;
    }


    /**
     * 定时触发器
     *
     *            任务
     * @return
     */
    @Bean(name = "firstJobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(JobDetail firstJobDetail) {

        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();

        tigger.setJobDetail(firstJobDetail);

        // cron表达式，每15m执行一次
        tigger.setCronExpression("0/1 * * * * ?");
        tigger.setName("firstJobJobTrigger");
        return tigger;
    }


    // 配置Scheduler
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger[] jobTriggers) {

        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
       // factoryBean.setOverwriteExistingJobs(true);

        // 延时启动，应用启动1秒后
       // factoryBean.setStartupDelay(1);

        factoryBean.setAutoStartup(true); //设置自行启动

        // 注册触发器
        factoryBean.setTriggers(jobTriggers);
        return factoryBean;
    }



}
