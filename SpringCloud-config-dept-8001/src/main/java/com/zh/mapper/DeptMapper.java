package com.zh.mapper;

import com.zh.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {

    Dept findById(Long id);

    List<Dept> findAll();

}
