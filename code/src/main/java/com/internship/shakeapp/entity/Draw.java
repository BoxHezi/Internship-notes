package com.internship.shakeapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Draw implements Serializable {

    private Long id;
    private Long userId;
    private int win; // 抽奖结果 0未中奖 1一等奖 2二等奖
    private Timestamp createTime;
    private Timestamp updateTime;
}
