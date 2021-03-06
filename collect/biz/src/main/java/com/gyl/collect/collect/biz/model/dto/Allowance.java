package com.gyl.collect.collect.biz.model.dto;

public class Allowance {
    private String uid;
    private String projectStart;
    private String projectEnd;
    private String projectDays;
    private String leaveDays;
    private String leaveDetail;
    private String mark;
    private Integer state;

    public String getProjectDays() {
        return projectDays;
    }

    public void setProjectDays(String projectDays) {
        this.projectDays = projectDays;
    }

    public String getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(String leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(String projectStart) {
        this.projectStart = projectStart;
    }

    public String getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(String projectEnd) {
        this.projectEnd = projectEnd;
    }

    public String getLeaveDetail() {
        return leaveDetail;
    }

    public void setLeaveDetail(String leaveDetail) {
        this.leaveDetail = leaveDetail;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
