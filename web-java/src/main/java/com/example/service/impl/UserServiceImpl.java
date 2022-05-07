package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.Result;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * @author shlcm
 */
@Service
public class UserServiceImpl implements IUserSevice {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询单个用户
     * @param
     * @return
     */
    @Override
    @Transactional
    public Result getUserInfo() {
        return Result.success(userMapper.getUserInfo());
    }

    @Override
    @Transactional
    public Result getAllUserInfo(List<Integer> userIds) {
        List<User> result=userMapper.getAllUserInfo(userIds);
        return Result.success(result);
    }

    /**
     * 新增单个用户
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Result addUser(User user) {
        return Result.success(userMapper.addUser(user));
    }

    @Override
    @Transactional
    public Result addAllUser(List<User> users) {
        System.out.println(users);
        int userList = userMapper.addAllUser(users);
        return Result.success(userList);
    }
    /**
     * 删除用户
     */
    @Override
    @Transactional
    public Result deleteAll(List<Integer> ids) {
        userMapper.deleteAll(ids);
        return Result.success(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(User upuser) {
        userMapper.updateById(upuser);
        return Result.success(null);
    }

    @Override
    @Transactional
    public Result updateName(Map<String,Object> userN) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        System.out.println(userN);
//        User newUser = (User) (EntityAndMap.map2Object(userN, User.class));

        User newUser = JSON.parseObject(JSON.toJSONString(userN), User.class);
        System.out.println(newUser);
        Object name = userN.get("name");
        queryWrapper.eq("name",name);
        userMapper.update(newUser,queryWrapper);
        return Result.success(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result updatexml(User upuser) {
        userMapper.updated(upuser);
        return Result.success(null);
    }
}
