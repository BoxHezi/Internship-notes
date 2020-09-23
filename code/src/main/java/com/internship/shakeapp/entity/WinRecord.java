package com.internship.shakeapp.entity;

import java.sql.Timestamp;

public class WinRecord {

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

    public Long getDrawId() {
        return drawId;
    }

    public void setDrawId(Long drawId) {
        this.drawId = drawId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
