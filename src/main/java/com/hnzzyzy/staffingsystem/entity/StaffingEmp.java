package com.hnzzyzy.staffingsystem.entity;

import com.baomidou.mybatisplus.annotations.TableId;

import java.util.Date;

/**
 * Created by dtkj_android on 2017/5/5.
 */
public class StaffingEmp {
    @TableId
    private long empId;//员工ID
    private String empName;//员工姓名
    private String empPhone;//员工手机号
    private String userName;//员工登录名
    private String empAvatarUrl;//员工头像
    private int empStatus;//员工状态
    private String otherInfo;//其他信息
    private Date createTime;//创建时间
    private Date entryTime;//入职时间
    private Date updateTime;//更新时间
    private Date beFormalTime;//转正时间

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpAvatarUrl() {
        return empAvatarUrl;
    }

    public void setEmpAvatarUrl(String empAvatarUrl) {
        this.empAvatarUrl = empAvatarUrl;
    }

    public int getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getBeFormalTime() {
        return beFormalTime;
    }

    public void setBeFormalTime(Date beFormalTime) {
        this.beFormalTime = beFormalTime;
    }

    public StaffingEmp() {
    }

    public StaffingEmp( String empName, String empPhone,String userName, String empAvatarUrl, int empStatus) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.userName = userName;
        this.empAvatarUrl = empAvatarUrl;
        this.empStatus = empStatus;
    }

    public StaffingEmp(String empName, String empPhone,String userName, String empAvatarUrl, int empStatus, String otherInfo, Date entryTime, Date beFormalTime) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.userName = userName;
        this.empAvatarUrl = empAvatarUrl;
        this.empStatus = empStatus;
        this.otherInfo = otherInfo;
        this.entryTime = entryTime;
        this.beFormalTime = beFormalTime;
    }

    public StaffingEmp(long empId, String empName, String empPhone, String empAvatarUrl, int empStatus, String otherInfo, Date entryTime, Date beFormalTime) {
        this.empId = empId;
        this.empName = empName;
        this.empPhone = empPhone;
        this.empAvatarUrl = empAvatarUrl;
        this.empStatus = empStatus;
        this.otherInfo = otherInfo;
        this.entryTime = entryTime;
        this.beFormalTime = beFormalTime;
    }

    public StaffingEmp(long empId, String empName, String empPhone, String userName, String empAvatarUrl, int empStatus, String otherInfo, Date entryTime, Date beFormalTime) {
        this.empId = empId;
        this.empName = empName;
        this.empPhone = empPhone;
        this.userName = userName;
        this.empAvatarUrl = empAvatarUrl;
        this.empStatus = empStatus;
        this.otherInfo = otherInfo;
        this.entryTime = entryTime;
        this.beFormalTime = beFormalTime;
    }

    @Override
    public String toString() {
        return "StaffingEmp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empAvatarUrl='" + empAvatarUrl + '\'' +
                ", empStatus='" + empStatus + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
