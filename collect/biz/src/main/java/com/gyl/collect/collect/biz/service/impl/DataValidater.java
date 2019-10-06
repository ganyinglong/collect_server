package com.gyl.collect.collect.biz.service.impl;

import com.gyl.collect.collect.biz.model.dto.AttendanceDTO;
import com.gyl.collect.collect.biz.model.dto.CollecteDTO;
import com.gyl.collect.collect.biz.service.AttendanceValidater;
import com.gyl.collect.core.util.BaseValidResult;
import com.gyl.collect.core.util.StringUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataValidater implements AttendanceValidater {
    @Override
    public BaseValidResult validAttendances(CollecteDTO collecteDTO) {
        BaseValidResult validResult = new BaseValidResult();
        List<AttendanceDTO> attendances = collecteDTO.getAttendances();
        Map<String, Integer> counts = new HashMap<>(attendances.size());
        for (int i = 0; i < attendances.size(); i++) {
            AttendanceDTO attendanceDTO = attendances.get(i);
            Integer integer = counts.get(attendanceDTO.getInputDate());
            if (integer == null) {
                counts.put(attendanceDTO.getInputDate(), 1);
            } else {
                validResult.addMessage(attendanceDTO.getInputDate() + " 存在重复数据，请检查后提交");
            }

            String inputDate = attendanceDTO.getInputDate();
            String checkinTime = attendanceDTO.getCheckinTime();
            String checkoutTime = attendanceDTO.getCheckoutTime();
            if (StringUtil.isEmpty(inputDate) || StringUtil.isEmpty(checkinTime) || StringUtil.isEmpty(checkoutTime)) {
                validResult.addMessage("第" + (i + 1) + "行数据缺失，请检查");
            } else {
                Integer year = collecteDTO.getYear();
                Integer selectedMonth = collecteDTO.getSelectedMonth();
                int y = Integer.valueOf(inputDate.substring(0, 4));
                int month = Integer.valueOf(inputDate.substring(5, 7));
                if (y != year || month != selectedMonth) {
                    validResult.addMessage("第" + (i + 1) + "行录入日期与选择的年月不符合，请检查");
                }
            }
        }

        return validResult;
    }

}
