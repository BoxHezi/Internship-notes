package com.internship.shakeapp.entity;

import java.util.Date;

public class WinRecord {

    private Long id;
    private Long userId;
    private Long companyId;
    private Long productId;
    private Long drawId;
    private Date createTime;
    private Date updateTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
