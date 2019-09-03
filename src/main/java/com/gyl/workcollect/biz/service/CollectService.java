package com.gyl.workcollect.biz.service;

import com.gyl.workcollect.biz.model.dto.AllowanceDTO;
import com.gyl.workcollect.biz.model.dto.CollecteDTO;

public interface CollectService {
    void submitCollect(CollecteDTO collecteDTO);

    void submitAllowance(AllowanceDTO allowanceDTO);
}
