package com.zh.service;

import com.zh.pojo.Dept;

import java.util.List;

public interface DeptService {

    Dept findById(Long id);

    List<Dept> findAll();

}
