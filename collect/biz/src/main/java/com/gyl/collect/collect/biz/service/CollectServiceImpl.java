package com.gyl.collect.collect.biz.service;

import com.gyl.collect.collect.biz.mapper.AllowanceMapper;
import com.gyl.collect.collect.biz.mapper.AttendanceMapper;
import com.gyl.collect.collect.biz.mapper.UserMapper;
import com.gyl.collect.collect.biz.model.dto.Allowance;
import com.gyl.collect.collect.biz.model.dto.AllowanceDTO;
import com.gyl.collect.collect.biz.model.dto.CollecteDTO;
import com.gyl.collect.collect.biz.model.po.Attendance;
import com.gyl.collect.collect.biz.model.po.UserPO;
import com.gyl.collect.core.util.DateUtil;
import com.gyl.collect.core.util.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private AllowanceMapper allowanceMapper;

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
                String inputDate = attendance.getInputDate();
                Attendance po = new Attendance();
                BeanUtils.copyProperties(attendance, po);
                int year = Integer.valueOf(inputDate.substring(0, 4));
                int month = Integer.valueOf(inputDate.substring(5, 7));
                po.setUid(uid);
                String inpuDay = inputDate.substring(0, 10);
                po.setInputDate(DateUtil.parse(inpuDay, "yyyy-MM-dd"));
                po.setCollectMonth(month);
                po.setCollectYear(year);
                String partten = "yyyy-MM-dd HH:mm:ss";
                po.setCheckinTime(DateUtil.parse(inpuDay + " " + attendance.getCheckinTime(), partten));
                po.setCheckoutTime(DateUtil.parse(inpuDay + " " + attendance.getCheckoutTime(), partten));
                po.setSubsidyStartTime(DateUtil.parse(inpuDay + " " + attendance.getSubsidyStartTime(), partten));
                attendanceMapper.saveAttendance(po);
            });
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void submitAllowance(AllowanceDTO allowanceDTO) {
        UserPO userPO = userMapper.queryUserByName(allowanceDTO.getUserName());
        boolean hasuser = userPO != null;
        if (!hasuser) {
            userPO = new UserPO();
            userPO.setId(UUIDUtil.uuidString());
        }
        userPO.setProjectName(allowanceDTO.getProjectName());
        userPO.setInitiationDate(allowanceDTO.getInitiationDate());
        userPO.setProbationEnd(allowanceDTO.getProbationEnd());
        userPO.setQuitDate(allowanceDTO.getQuitDate());

        String uid = userPO.getId();
        if (hasuser) {
            userMapper.updateUser(userPO);
        } else {
            userMapper.saveUser(userPO);
        }
        List<Allowance> allowances = allowanceDTO.getTableData();
        if (allowances != null && allowances.size() > 0) {
            allowances.forEach(allowance -> {
                allowance.setUid(uid);
                allowanceMapper.saveAllowance(allowance);
            });
        }

    }
}
