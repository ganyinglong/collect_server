package com.gyl.workcollect.biz.service;

import com.gyl.workcollect.biz.mapper.AttendanceMapper;
import com.gyl.workcollect.biz.mapper.UserMapper;
import com.gyl.workcollect.biz.model.dto.CollecteDTO;
import com.gyl.workcollect.biz.model.po.UserPO;
import com.gyl.workcollect.core.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public void submitCollect(CollecteDTO collecteDTO) {
        UserPO userPO = userMapper.queryUserByName(collecteDTO.getUserName());
        String uid;
        if (userPO != null) {
            uid = userPO.getId();
            userPO.setWorkPlace(collecteDTO.getWorkPlace());
            userPO.setEmpNo(collecteDTO.getEmpNo());
            userMapper.updateUser(userPO);
        } else {
            uid = UUIDUtil.uuidString();
            UserPO user = new UserPO();
            user.setId(uid);
            user.setEmpNo(collecteDTO.getEmpNo());
            user.setWorkPlace(collecteDTO.getWorkPlace());
            user.setUserName(collecteDTO.getUserName());
            userMapper.saveUser(user);
        }

        Optional.ofNullable(collecteDTO).map(CollecteDTO::getAttendances).ifPresent(attendances -> {
            attendances.forEach(attendance -> {
                attendance.setUid(uid);
                String inputDate = attendance.getInputDate();
                int year = Integer.valueOf(inputDate.substring(0, 4));
                int month = Integer.valueOf(inputDate.substring(5, 7));
                attendance.setInputDate(inputDate.substring(0, 10));
                attendance.setCollectMonth(month);
                attendance.setCollectYear(year);
                attendanceMapper.saveAttendance(attendance);
            });
        });
    }
}
