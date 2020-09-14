package com.zh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zh.pojo.Dept;
import com.zh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/13 17:29
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 获取配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    /*
     * 使用Hystrix进行服务熔断
     * 当服务发生异常，进入备用方案
     * @HystrixCommand
     *  fallbackMethod：失败的调用方法
     */
    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept findById(@PathVariable("id") Long id){
        Dept dept = deptService.findById(id);

        if (dept == null){
            throw new RuntimeException("不存在该用户，信息无法找到");
        }

        return dept;
    }

    // 备用方案 当服务发生异常，调用次方法，返回一个模拟数据
    public Dept hystrixGet(@PathVariable("id") Long id){

        Dept dept = new Dept();
        dept.setId(id);
        dept.setDname("没有该用户");
        dept.setDb_source("no this db");
        return dept;
    }


    @GetMapping("/dept/list")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services："+services);

        //得到一个具体的微服务信息，通过具体的微服务id，applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
        }

        return this.client;
    }
}
