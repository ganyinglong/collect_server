package com.gyl.collect.collect.biz.mapper;

import com.gyl.collect.collect.biz.model.dto.Allowance;

import java.util.List;

public interface AllowanceMapper {

    void saveAllowance(Allowance allowance);

    List<Allowance> selectAllowancesByUid(String uid);

}
