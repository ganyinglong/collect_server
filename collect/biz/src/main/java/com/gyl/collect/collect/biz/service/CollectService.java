package com.gyl.collect.collect.biz.service;

import com.gyl.collect.collect.biz.model.dto.Allowance;
import com.gyl.collect.collect.biz.model.dto.AllowanceDTO;
import com.gyl.collect.collect.biz.model.dto.AttendanceDTO;
import com.gyl.collect.collect.biz.model.dto.CollecteDTO;

import java.util.List;

public interface CollectService {
    void submitCollect(CollecteDTO collecteDTO);

    void submitAllowance(AllowanceDTO allowanceDTO);

    List<AttendanceDTO> quryUserAttendance(String uid, String year, String month);

    List<Allowance> queryUserAllowances(String uid);
}
