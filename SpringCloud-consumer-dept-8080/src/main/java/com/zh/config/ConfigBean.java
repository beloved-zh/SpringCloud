package com.zh.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Beloved
 * @date 2020/9/13 17:37
 */
@Configuration
public class ConfigBean {

    /*
     * 配置负载均衡实现RestTemplate
     * IRule：负载均衡规则的接口
     *      RoundRobinRule：伦循
     *      RandomRule：随机
     *      AvailabilityFilteringRule：会先过滤掉，崩溃的服务，对剩下的进行伦循
     *      RetryRule：会先按照伦循获取服务，如果服务获取失败，则在指定时间内进行重试
     *      ......
     */
    @Bean
    @LoadBalanced //Ribbon 配置此注解自动实现负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    // 使用随机的负载均衡机制
//    @Bean
//    public IRule iRule(){
//        return new RandomRule();
//    }
}
