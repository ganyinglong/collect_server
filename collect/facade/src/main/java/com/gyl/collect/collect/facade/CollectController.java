package com.gyl.collect.collect.facade;

import com.gyl.collect.collect.biz.model.dto.Allowance;
import com.gyl.collect.collect.biz.model.dto.AllowanceDTO;
import com.gyl.collect.collect.biz.model.dto.AttendanceDTO;
import com.gyl.collect.collect.biz.model.dto.CollecteDTO;
import com.gyl.collect.collect.biz.service.AttendanceValidater;
import com.gyl.collect.collect.biz.service.CollectService;
import com.gyl.collect.core.util.BaseResult;
import com.gyl.collect.core.util.BaseValidResult;
import com.gyl.collect.core.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollectController {
    @Autowired
    private CollectService collectService;
    @Autowired
    private List<AttendanceValidater> validaters;

    @PostMapping("/workcollect/submitCollect")
    public BaseResult submitCollect(@RequestBody CollecteDTO collecteDTO) {
        for (AttendanceValidater validater : validaters) {
            BaseValidResult baseValidResult = validater.validAttendances(collecteDTO);
            if (!baseValidResult.isValid()) {
                return new BaseResult(ResultCode.BUSINESS_EXCEPTION.getCode(), baseValidResult.mergeMessage());
            }
        }
        collectService.submitCollect(collecteDTO);
        return new BaseResult();
    }

    @PostMapping("/workcollect/submitAllowance")
    public BaseResult submitAllowance(@RequestBody AllowanceDTO allowanceDTO) {
        collectService.submitAllowance(allowanceDTO);
        return new BaseResult();
    }

    @GetMapping("/workcollect/quryUserAttendance")
    public BaseResult quryUserAttendance(@RequestParam("uid") String uid, @RequestParam("year") String year, @RequestParam("month") String month) {
        List<AttendanceDTO> attendances = collectService.quryUserAttendance(uid, year, month);
        return new BaseResult(attendances);
    }

    @GetMapping("/workcollect/queryAllowance")
    public BaseResult queryAllowance(@RequestParam("uid") String uid) {
        List<Allowance> allowances = collectService.queryUserAllowances(uid);
        return new BaseResult(allowances);
    }

}
