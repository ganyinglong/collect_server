package com.gyl.workcollect.biz.mapper;

import com.gyl.workcollect.biz.model.dto.Allowance;

import java.util.List;

public interface AllowanceMapper {

    void saveAllowance(Allowance allowance);

    List<Allowance> selectAllowancesByUid(String uid);
}
