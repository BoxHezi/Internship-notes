package com.internship.shakeapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class Product implements Serializable {

    private Long id;
    private Long companyId;
    private String productName;
    private int stockCount;
    private Double salePrice;
    private Double promotionPrice;
    private Timestamp createTime;
    private Timestamp updateTime;

    // TODO: 预留一些可扩展字段, 通用字段
}
