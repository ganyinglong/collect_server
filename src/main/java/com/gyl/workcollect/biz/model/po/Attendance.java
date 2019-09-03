package com.gyl.workcollect.biz.model.po;

import java.util.Date;

public class Attendance extends BasePO {
    private String uid;
    private Date inputDate;
    private String dateType;
    private Date checkinTime;
    private Date checkoutTime;
    private Date subsidyStartTime;
    private Float subsidyLength;
    private Integer subsidyAmount;
    private Integer collectMonth;
    private Integer collectYear;

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Date getSubsidyStartTime() {
        return subsidyStartTime;
    }

    public void setSubsidyStartTime(Date subsidyStartTime) {
        this.subsidyStartTime = subsidyStartTime;
    }

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

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
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
