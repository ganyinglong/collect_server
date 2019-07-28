package com.gyl.workcollect.biz.model.po;

public class UserPO extends  BasePO{
   private String userName;
   private String empNo;
   private String workPlace;
   private String deptLv1;
   private String deptLv2;
   private String mobile;

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
}
