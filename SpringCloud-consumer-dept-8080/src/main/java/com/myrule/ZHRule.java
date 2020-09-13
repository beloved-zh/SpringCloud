package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Beloved
 * @date 2020/9/13 22:56
 *
 * 自定义的负载均衡必须是Configuration且不能和启动类在同一级目录，负责就与RibbonClients共享
 */
@Configuration
@Component
public class ZHRule {



    @Bean
    public IRule iRule(){
        return new MyRandomRule(); // 默认是伦循的，现在使用自己的
    }

}
