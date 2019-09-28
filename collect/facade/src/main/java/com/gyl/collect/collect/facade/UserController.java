package com.gyl.collect.collect.facade;

import com.gyl.collect.collect.biz.mapper.UserMapper;
import com.gyl.collect.collect.biz.model.po.UserPO;
import com.gyl.collect.core.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/workcollect/queryUserByUserName")
    public BaseResult<UserPO> queryUserByUserName(String userName) {
        UserPO userPO = userMapper.queryUserByName(userName);
        return new BaseResult<>(userPO);
    }

}
