package com.gyl.collect.collect.facade;

import com.gyl.collect.core.util.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExportController {

    @GetMapping("/export/collect")
    public BaseResult exportCollect(Integer year, Integer month) {

        return new BaseResult();
    }
}
