package com.gyl.workcollect.biz.controller;

import com.gyl.workcollect.biz.mapper.UserMapper;
import com.gyl.workcollect.biz.model.po.UserPO;
import com.gyl.workcollect.core.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/workcollect/queryUserByUserName")
    public BaseResult<UserPO> queryUserByUserName(String userName){
        UserPO userPO = userMapper.queryUserByName(userName);
        return new BaseResult<>(userPO);
    }

}
