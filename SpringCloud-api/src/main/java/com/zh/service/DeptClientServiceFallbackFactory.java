package com.zh.service;

import com.zh.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/14 15:06
 *
 * 服务降级
 * 对整合service进行操作
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {


    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public Dept findById(Long id) {
                Dept dept = new Dept();
                dept.setId(id);
                dept.setDname("该服务以降级，被关闭");
                dept.setDb_source("没有数据");
                return dept;
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        };
    }
}
