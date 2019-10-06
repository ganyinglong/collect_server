package com.gyl.collect.collect.biz.mapper;

import com.gyl.collect.collect.biz.model.po.Attendance;

import java.util.List;
import java.util.Map;

public interface AttendanceMapper {

    int saveAttendance(Attendance attendance);

    int updateAttendance(Attendance attendance);

    Integer countAttendance(Attendance attendance);

    /**
     * 查询用户特定月份的加班数据
     *
     * @param paraMap
     * @return
     */
    List<Attendance> quryUserAttendance(Map<String, Object> paraMap);

    void deleteByMonth(Attendance attendance);


}
