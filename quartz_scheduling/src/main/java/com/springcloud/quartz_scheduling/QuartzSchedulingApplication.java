package com.springcloud.quartz_scheduling;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.boot.SpringApplication;


@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class QuartzSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzSchedulingApplication.class, args);
    }

}
