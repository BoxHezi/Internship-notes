package com.internship.shakeapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class User implements Serializable {

    private Long id;
    private String username;

    transient private String password;
    transient private String salt;

    private Timestamp createTime;
    private Timestamp updateTime;

    private Integer type; // 用户类型 1为普通用户 2为企业用户
}
