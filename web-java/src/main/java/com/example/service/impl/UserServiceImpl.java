package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.ErrorCode;
import com.example.common.Result;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.IUserSevice;
import com.example.vo.UserVoList;
import com.example.vo.params.UserPageParams;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
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
     *
     * @param
     * @return
     */
    @Override
    @Transactional
    public Result getAllUser(UserPageParams userPageParams) {
        System.out.println(userPageParams);
        Page<User> page = new Page<>(userPageParams.getCurrentPage(), userPageParams.getPageSize());
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(userPageParams.getKeyWord())) {
            lambdaQueryWrapper.eq(User :: getAccount, userPageParams.getKeyWord());
        }
        Page<User> userPage = userMapper.selectPage(page, lambdaQueryWrapper);
        List<User> userList = userPage.getRecords();
        long total = userPage.getTotal();
        UserVoList<User> userVoList = new UserVoList();
        userVoList.setUserList(userList);
        userVoList.setTotal(total);
        return Result.success(userVoList);
    }

    //添加用户
    @Override
    public Result addUser(User user) throws Exception {
        User existedUser = userMapper.find(user);
        if (existedUser == null) {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
            userMapper.insert(user);
            return Result.success(user);
        } else {
            return Result.fail(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_EXIST.getMsg());
        }
    }

    //删除用户
    @Override
    public Result deleteUser(List ids) {
        List<User> userList = userMapper.getUserByIds(ids);
        List<User> adminList = new ArrayList<>();
        for (User user : userList) {
            if (user.getAdmin() == 1) {
                adminList.add(user);
            }
        }
        List<User> allAdmin = userMapper.getAllAdmin();
        if (allAdmin.size() == adminList.size()) {
            return Result.fail(1, "不可以将所有管理员都删除，必须保留一个");
        }

        userMapper.deleteUser(ids);
        return Result.success("success");
    }

    //更新用户
    @Override
    public Result updateUser(User user) throws Exception {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        boolean result=userMapper.updateUser(user);
        if(result){
            return Result.success(user);
        }else{
            return Result.fail(1, "更新失败");
        }
    }
}
