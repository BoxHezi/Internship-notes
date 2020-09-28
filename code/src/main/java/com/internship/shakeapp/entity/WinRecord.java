package com.internship.shakeapp.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class WinRecord implements Serializable {

    private Long id;
    private Long userId;
    private Long companyId;
    private Long productId;
    private Long drawId;
    private Timestamp createTime;
    private Timestamp updateTime;

    public WinRecord(Long productId, Long companyId, Long userId, Long drawId) {
        this.productId = productId;
        this.companyId = companyId;
        this.userId = userId;
        this.drawId = drawId;
    }
}
