package com.gyl.workcollect.biz.service;

import com.gyl.workcollect.biz.model.dto.CollecteDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface CollectService {
    void submitCollect(@RequestBody CollecteDTO collecteDTO);
}
