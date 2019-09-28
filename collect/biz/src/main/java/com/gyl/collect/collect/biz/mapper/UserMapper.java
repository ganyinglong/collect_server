package com.gyl.collect.collect.biz.mapper;

import com.gyl.collect.collect.biz.model.po.UserPO;

public interface UserMapper {
    UserPO queryUserByName(String userName);

    void updateUser(UserPO userPO);

    void saveUser(UserPO userPO);
}
