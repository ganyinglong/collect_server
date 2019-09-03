package com.gyl.workcollect.biz.model.dto;

import java.util.Date;
import java.util.List;

public class AllowanceDTO {
    private String userName;
    private String empNo;
    private String projectName;
    private Date initiationDate;
    private Date probationEnd;
    private Date quitDate;
    private List<Allowance> tableData;

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

    public List<Allowance> getTableData() {
        return tableData;
    }

    public void setTableData(List<Allowance> tableData) {
        this.tableData = tableData;
    }
}
