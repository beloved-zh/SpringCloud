package com.zh;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author Beloved
 * @date 2020/9/13 17:33
 */
@SpringBootApplication
@EnableEurekaClient // 在服务启动后自动注册到Eureka中
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker // 开启对熔断的支持
public class DeptProvider_8002 {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8002.class,args);
    }

    // 增加一个Servlet
    @Bean
    public ServletRegistrationBean a(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
