package com.gyl.workcollect.biz.service;

import com.gyl.workcollect.biz.mapper.AttendanceMapper;
import com.gyl.workcollect.biz.mapper.UserMapper;
import com.gyl.workcollect.biz.model.dto.CollecteDTO;
import com.gyl.workcollect.biz.model.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public void submitCollect(CollecteDTO collecteDTO) {
        UserPO userPO = userMapper.queryUserByName(collecteDTO.getUserName());
        if (userPO != null) {
            String uid = userPO.getId();
            collecteDTO.getAttendances().forEach(attendance -> {
                attendance.setUid(uid);
                String inputDate = attendance.getInputDate();
                int year = Integer.valueOf(inputDate.substring(0, 4));
                int month = Integer.valueOf(inputDate.substring(5, 7));
                attendance.setInputDate(inputDate.substring(0, 10));
                attendance.setCollectMonth(month);
                attendance.setCollectYear(year);
                attendanceMapper.saveAttendance(attendance);
            });
        }
    }
}
