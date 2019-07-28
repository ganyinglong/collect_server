package com.gyl.workcollect.biz.mapper;

import com.gyl.workcollect.biz.model.po.UserPO;

public interface UserMapper {
    UserPO queryUserByName(String userName);
}
