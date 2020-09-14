package com.zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Beloved
 * @date 2020/9/13 17:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zh.service"}) // 扫描Feign的service的包
//@ComponentScan({"com.zh"}) // 服务降级这里必须扫描到FallbackFactory实现的类
public class FeignDeptConsumer_8080 {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_8080.class,args);
    }

}
