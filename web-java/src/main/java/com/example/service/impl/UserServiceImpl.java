package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.Result;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserSevice;
import com.example.vo.UserVoList;
import com.example.vo.params.UserPageParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
    public Result getAllUser(UserPageParams userPageParams) {
        System.out.println(userPageParams);
        Page<User> page = new Page<>(userPageParams.getCurrentPage(),userPageParams.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(userPageParams.getKeyWord())){
            lambdaQueryWrapper.eq(User::getAccount,userPageParams.getKeyWord());
        }
        Page<User> userPage = userMapper.selectPage(page, lambdaQueryWrapper);
        List<User> userList = userPage.getRecords();
        long total = userPage.getTotal();
        UserVoList<User> userVoList = new UserVoList();
        userVoList.setUserList(userList);
        userVoList.setTotal(total);
        return Result.success(userVoList);
    }
}
