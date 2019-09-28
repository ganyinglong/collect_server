package com.gyl.collect.collect.biz.model.po;

import java.util.Date;

public class UserPO extends BasePO {
    private String userName;
    private String empNo;
    private String workPlace;
    private String deptLv1;
    private String deptLv2;
    private String mobile;
    private String projectName;
    private Date initiationDate;
    private Date probationEnd;
    private Date quitDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getDeptLv1() {
        return deptLv1;
    }

    public void setDeptLv1(String deptLv1) {
        this.deptLv1 = deptLv1;
    }

    public String getDeptLv2() {
        return deptLv2;
    }

    public void setDeptLv2(String deptLv2) {
        this.deptLv2 = deptLv2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getInitiationDate() {
        return initiationDate;
    }

    public void setInitiationDate(Date initiationDate) {
        this.initiationDate = initiationDate;
    }

    public Date getProbationEnd() {
        return probationEnd;
    }

    public void setProbationEnd(Date probationEnd) {
        this.probationEnd = probationEnd;
    }

    public Date getQuitDate() {
        return quitDate;
    }

    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }
}
