package com.gyl.workcollect.biz.controller;

import com.gyl.workcollect.biz.model.dto.CollecteDTO;
import com.gyl.workcollect.biz.service.CollectService;
import com.gyl.workcollect.core.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectController {
    @Autowired
    private CollectService collectService;

    @PostMapping("/workcollect/submitCollect")
    public BaseResult submitCollect(@RequestBody CollecteDTO collecteDTO) {
        collectService.submitCollect(collecteDTO);
        return new BaseResult();
    }
}
