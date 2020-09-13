package com.zh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Beloved
 * @date 2020/9/13 17:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept implements Serializable {

    private Long id;
    private String dname;

    // 标识数据库 有可能一个服务对应一个数据库 同一信息在不同数据库
    private String db_source;

}
