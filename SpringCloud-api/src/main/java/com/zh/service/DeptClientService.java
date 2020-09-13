package com.zh.service;

import com.zh.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/13 23:31
 */
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
@Component
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept findById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    List<Dept> findAll();

}
