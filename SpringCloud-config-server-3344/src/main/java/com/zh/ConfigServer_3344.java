package com.zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Beloved
 * @date 2020/9/15 9:24
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServer_3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_3344.class,args);
    }

}
