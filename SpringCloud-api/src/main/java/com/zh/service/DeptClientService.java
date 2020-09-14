package com.zh.service;

import com.zh.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/13 23:31
 */
/*
 * @FeignClient
 *  value：服务名
 *  fallbackFactory：服务降级对应的实现类
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @RequestMapping("/dept/get/{id}")
    Dept findById(@PathVariable("id") Long id);

    @RequestMapping("/dept/list")
    List<Dept> findAll();

}
