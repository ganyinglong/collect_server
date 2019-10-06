package com.gyl.collect.collect.biz.service.impl;

import com.gyl.collect.collect.biz.mapper.AllowanceMapper;
import com.gyl.collect.collect.biz.mapper.AttendanceMapper;
import com.gyl.collect.collect.biz.mapper.UserMapper;
import com.gyl.collect.collect.biz.model.dto.Allowance;
import com.gyl.collect.collect.biz.model.dto.AllowanceDTO;
import com.gyl.collect.collect.biz.model.dto.AttendanceDTO;
import com.gyl.collect.collect.biz.model.dto.CollecteDTO;
import com.gyl.collect.collect.biz.model.po.Attendance;
import com.gyl.collect.collect.biz.model.po.UserPO;
import com.gyl.collect.collect.biz.service.CollectService;
import com.gyl.collect.core.util.DateUtil;
import com.gyl.collect.core.util.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private AllowanceMapper allowanceMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
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


        Integer year = collecteDTO.getYear();
        Integer month = collecteDTO.getSelectedMonth();
        Attendance a = new Attendance();
        a.setCollectMonth(month);
        a.setCollectYear(year);
        attendanceMapper.deleteByMonth(a);
        Optional.ofNullable(collecteDTO).map(CollecteDTO::getAttendances).ifPresent(attendances -> {
            attendances.forEach(attendance -> {
                String inputDate = attendance.getInputDate();
                Attendance po = new Attendance();
                BeanUtils.copyProperties(attendance, po);
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
            Allowance allowance = allowances.get(0);
            allowance.setUid(uid);
            allowanceMapper.saveAllowance(allowance);
        }

    }

    @Override
    public List<AttendanceDTO> quryUserAttendance(String uid, String year, String month) {
        Map<String, Object> para = new HashMap<>();
        para.put("uid", uid);
        para.put("year", year);
        para.put("month", month);
        List<Attendance> attendances = attendanceMapper.quryUserAttendance(para);
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>(attendances.size());
        attendances.forEach(a -> {
            AttendanceDTO attendanceDTO = new AttendanceDTO();
            BeanUtils.copyProperties(a, attendanceDTO);
            attendanceDTO.setInputDate(DateUtil.format(a.getInputDate(), DateUtil.YYYY_MM_DD));
            attendanceDTO.setCheckinTime(DateUtil.format(a.getCheckinTime(), DateUtil.HH_MM_SS));
            attendanceDTO.setCheckoutTime(DateUtil.format(a.getCheckoutTime(), DateUtil.HH_MM_SS));
            attendanceDTO.setSubsidyStartTime(DateUtil.format(a.getSubsidyStartTime(), DateUtil.HH_MM_SS));
            attendanceDTOS.add(attendanceDTO);
        });
        return attendanceDTOS;
    }

    @Override
    public List<Allowance> queryUserAllowances(String uid) {
        return allowanceMapper.selectAllowancesByUid(uid);
    }
}
