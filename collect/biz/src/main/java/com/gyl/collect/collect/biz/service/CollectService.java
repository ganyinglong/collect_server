package com.gyl.collect.collect.biz.service;

import com.gyl.collect.collect.biz.model.dto.AllowanceDTO;
import com.gyl.collect.collect.biz.model.dto.CollecteDTO;

public interface CollectService {
    void submitCollect(CollecteDTO collecteDTO);

    void submitAllowance(AllowanceDTO allowanceDTO);
}
