package com.gyl.workcollect.biz.model.dto;

import com.gyl.workcollect.biz.model.po.BasePO;

public class Attendance extends BasePO {
    private String uid;
    private String inputDate;
    private String dateType;
    private String checkinTime;
    private String checkoutTime;
    private String subsidyStartTime;
    private Float subsidyLength;
    private Integer subsidyAmount;
    private Integer collectMonth;
    private Integer collectYear;

    public Integer getCollectMonth() {
        return collectMonth;
    }

    public void setCollectMonth(Integer collectMonth) {
        this.collectMonth = collectMonth;
    }

    public Integer getCollectYear() {
        return collectYear;
    }

    public void setCollectYear(Integer collectYear) {
        this.collectYear = collectYear;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getSubsidyStartTime() {
        return subsidyStartTime;
    }

    public void setSubsidyStartTime(String subsidyStartTime) {
        this.subsidyStartTime = subsidyStartTime;
    }

    public Float getSubsidyLength() {
        return subsidyLength;
    }

    public void setSubsidyLength(Float subsidyLength) {
        this.subsidyLength = subsidyLength;
    }

    public Integer getSubsidyAmount() {
        return subsidyAmount;
    }

    public void setSubsidyAmount(Integer subsidyAmount) {
        this.subsidyAmount = subsidyAmount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
