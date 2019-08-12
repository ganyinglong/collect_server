package com.gyl.workcollect.biz.mapper;

import com.gyl.workcollect.biz.model.po.UserPO;

public interface UserMapper {
    UserPO queryUserByName(String userName);

    void updateUser(UserPO userPO);

    void saveUser(UserPO userPO);
}
