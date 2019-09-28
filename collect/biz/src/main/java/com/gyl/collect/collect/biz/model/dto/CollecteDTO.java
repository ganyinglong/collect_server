package com.gyl.collect.collect.biz.model.dto;

import java.util.List;

public class CollecteDTO {
    private String userName;
    private String empNo;
    private String workPlace;
    private List<AttendanceDTO> attendances;

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

    public List<AttendanceDTO> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<AttendanceDTO> attendances) {
        this.attendances = attendances;
    }
}
