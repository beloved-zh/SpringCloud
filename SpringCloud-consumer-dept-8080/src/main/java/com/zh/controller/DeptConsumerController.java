package com.zh.controller;

import com.zh.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/13 17:39
 */
@RestController
public class DeptConsumerController {

    // 消费者，直接调用生产者

    @Autowired
    private RestTemplate restTemplate; // 提供多种便携访问http服务的方法

    // 这里的地址，应该是一个变量，通过服务名访问，服务的调用不用关心ip和端口
    // private static final String REST_URL_PREFIX = "http://localhost:8000";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list/",List.class);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
}
