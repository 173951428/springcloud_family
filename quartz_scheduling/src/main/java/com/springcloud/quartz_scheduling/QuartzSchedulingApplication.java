package com.springcloud.quartz_scheduling;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
@ComponentScan
public class QuartzSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzSchedulingApplication.class, args);
    }

}
