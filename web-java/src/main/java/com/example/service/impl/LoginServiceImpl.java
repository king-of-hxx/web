package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.ErrorCode;
import com.example.common.Result;
import com.example.entity.User;
import com.example.mapper.LoginMapper;
import com.example.service.LoginService;
import com.example.vo.params.LoginParams;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shlcm
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Result login(LoginParams loginParams) {
        System.out.println(loginParams);
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        password = DigestUtils.md5Hex(password);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAccount,account);
        lambdaQueryWrapper.eq(User::getPassword,password);
        lambdaQueryWrapper.select(User::getId,User::getAccount);
        lambdaQueryWrapper.last("limit " + 1);
        User loginUserInfo = loginMapper.selectOne(lambdaQueryWrapper);
        System.out.println(loginUserInfo);
        if(loginUserInfo == null){
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(),ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        return Result.success(null);
    }
}
