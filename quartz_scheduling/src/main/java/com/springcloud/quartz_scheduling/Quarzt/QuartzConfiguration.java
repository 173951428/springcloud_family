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


    /**
     * 配置定时任务1,配置注入返回 MethodInvokingJobDetailFactoryBean 对象
     * @param jobDetailList
     * @return
     */
    @Bean(name = "firstJobDetail")
    public MethodInvokingJobDetailFactoryBean firstJobDetail(JobDetailList jobDetailList){
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        jobDetail.setConcurrent(false);

        // 设置任务的名字
        jobDetail.setName("firstJobDetail");

        // 设置任务的分组，在多任务的时候使用
        jobDetail.setGroup("firstJobDetailJobGroup");

        // 需要执行的对象
        jobDetail.setTargetObject(jobDetailList);
        /*
         * TODO 非常重要 执行QuartzTask类中的需要执行方法
         */
        jobDetail.setTargetMethod("firstJobDetail");



        return jobDetail;
    }


    /**
     * 配置定时任务1，配置注入返回 CronTriggerFactoryBean
     * @param firstJobDetail
     * @return
     */
    @Bean(name = "firstJobTrigger")
    public CronTriggerFactoryBean firstJobTrigger(JobDetail firstJobDetail) {

        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();

        tigger.setJobDetail(firstJobDetail);

        // cron表达式，每15m执行一次
        tigger.setCronExpression("0/1 * * * * ?");
        tigger.setName("firstJobTrigger");
        return tigger;
    }
//-----------------------------------------------------------------------------------------------------------------------

    /**
     * 配置定时任务2,返回 MethodInvokingJobDetailFactoryBean
     * @param jobDetailList
     * @return
     */
    @Bean(name = "secondJobDetail")
    public MethodInvokingJobDetailFactoryBean secondJobDetail(JobDetailList jobDetailList){
        MethodInvokingJobDetailFactoryBean secondJobDetail = new MethodInvokingJobDetailFactoryBean();
        // 是否并发执行
        secondJobDetail.setConcurrent(false);

        // 设置任务的名字
        secondJobDetail.setName("secondJobDetail");

        // 设置任务的分组，在多任务的时候使用
        secondJobDetail.setGroup("secondJobDetailJobGroup");

        // 需要执行的对象
        secondJobDetail.setTargetObject(jobDetailList);
        /*
         * TODO 非常重要 执行QuartzTask类中的需要执行方法
         */
        secondJobDetail.setTargetMethod("secondJobDetail");

        return secondJobDetail;
    }


    /**
     *  配置定时任务2 定时触发器。每2秒触发一次
     * @param secondJobDetail
     * @return
     */
    @Bean(name = "secondJobTrigger")
    public CronTriggerFactoryBean secondJobTrigger(JobDetail secondJobDetail) {

        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();

        tigger.setJobDetail(secondJobDetail);

        // cron表达式，每2s执行一次
        tigger.setCronExpression("0/2 * * * * ?");
        tigger.setName("secondJobTrigger");
        return tigger;
    }


    /**
     * 调度工厂，负责调度全部的定时任务
     * @param jobTriggers
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger[] jobTriggers) {

        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        factoryBean.setOverwriteExistingJobs(true);

        // 延时启动，应用启动1秒后
        factoryBean.setStartupDelay(1);

        factoryBean.setAutoStartup(true); //设置自行启动

        // 注册触发器
        factoryBean.setTriggers(jobTriggers);
        return factoryBean;
    }



}
