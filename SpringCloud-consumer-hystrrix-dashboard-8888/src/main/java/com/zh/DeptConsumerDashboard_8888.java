package com.zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Beloved
 * @date 2020/9/14 20:51
 */
@SpringBootApplication
@EnableHystrixDashboard // 开启监控页面
public class DeptConsumerDashboard_8888 {

    /*
     *  想在dashboard里监控某个服务 这个服务本身得先 主启动类上@EnableCircuitBreaker 开启熔断开关
     *  然后注入一个ServletBean
     *  同时这个服务的控制器里,必须有@HystrixCommand的注解，
     *  用来标识要把哪些接口方法展示在dashboard上
     */
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboard_8888.class,args);
    }

}
