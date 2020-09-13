package com.zh;

import com.myrule.ZHRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Beloved
 * @date 2020/9/13 17:50
 */
@SpringBootApplication
@EnableEurekaClient
// 在微服务启动的时候就能加载自定义的负载均衡策略 name服务名
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = ZHRule.class)
public class DeptConsumer_8080 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8080.class,args);
    }

}
