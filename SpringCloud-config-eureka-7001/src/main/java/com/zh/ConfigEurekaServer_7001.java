package com.zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Beloved
 * @date 2020/9/13 18:10
 */
@SpringBootApplication
@EnableEurekaServer // 服务端的启动类，可以接收别人注册进来
public class ConfigEurekaServer_7001 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaServer_7001.class,args);
    }

}
