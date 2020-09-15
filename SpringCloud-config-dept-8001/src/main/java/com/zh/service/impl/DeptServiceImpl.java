package com.zh.service.impl;

import com.zh.mapper.DeptMapper;
import com.zh.pojo.Dept;
import com.zh.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/13 17:26
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public Dept findById(Long id) {
        return deptMapper.findById(id);
    }

    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
