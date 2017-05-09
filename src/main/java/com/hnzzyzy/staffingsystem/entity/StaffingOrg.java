package com.hnzzyzy.staffingsystem.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * Created by xcy on 2017/5/7.
 */
@TableName("staffing_org")
public class StaffingOrg {
    @TableId
    private long orgId;
    private String orgName;
    private long pOrgId;
    private Date createTime;
    private int orgType;

    public StaffingOrg() {
    }

    public StaffingOrg(long orgId, String orgName, long pOrgId) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.pOrgId = pOrgId;
    }

    public StaffingOrg(long orgId, String orgName, long pOrgId, Date createTime, int orgType) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.pOrgId = pOrgId;
        this.createTime = createTime;
        this.orgType = orgType;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public long getpOrgId() {
        return pOrgId;
    }

    public void setpOrgId(long pOrgId) {
        this.pOrgId = pOrgId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getOrgType() {
        return orgType;
    }

    public void setOrgType(int orgType) {
        this.orgType = orgType;
    }

    @Override
    public String toString() {
        return "StaffingOrg{" +
                "orgId=" + orgId +
                ", orgName='" + orgName + '\'' +
                ", pOrgId=" + pOrgId +
                ", createTime=" + createTime +
                ", orgType=" + orgType +
                '}';
    }
}
