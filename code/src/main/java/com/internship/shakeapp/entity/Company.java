package com.internship.shakeapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class Company implements Serializable {
    private Long id; // company id
    private String companyName; // company name
    private Long userId;
    private Timestamp createTime;
    private Timestamp updateTime;

    private List<Product> products;
}
