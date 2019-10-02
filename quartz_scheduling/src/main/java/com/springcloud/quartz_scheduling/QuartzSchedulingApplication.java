package com.springcloud.quartz_scheduling;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
@ComponentScan
@MapperScan(value = "com.springcloud.quartz_scheduling.mapper")
public class QuartzSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzSchedulingApplication.class, args);
    }

}
