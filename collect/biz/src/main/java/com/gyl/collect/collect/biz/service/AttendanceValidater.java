package com.gyl.collect.collect.biz.service;

import com.gyl.collect.collect.biz.model.dto.CollecteDTO;
import com.gyl.collect.core.util.BaseValidResult;

public interface AttendanceValidater {

    BaseValidResult validAttendances(CollecteDTO collecteDTO);
}
