package com.hnzzyzy.staffingsystem.entity;

import java.util.Date;

/**
 * Created by xcy on 2017/5/7.
 */
public class StaffingOrg {
    private long orgId;
    private String orgName;
    private long pOrg;
    private Date createTime;
    private int orgType;

    public StaffingOrg() {
    }

    public StaffingOrg(long orgId, String orgName, long pOrg) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.pOrg = pOrg;
    }

    public StaffingOrg(long orgId, String orgName, long pOrg, Date createTime, int orgType) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.pOrg = pOrg;
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

    public long getpOrg() {
        return pOrg;
    }

    public void setpOrg(long pOrg) {
        this.pOrg = pOrg;
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
                ", pOrg=" + pOrg +
                ", createTime=" + createTime +
                ", orgType=" + orgType +
                '}';
    }
}
