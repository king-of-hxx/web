package com.example.service;

import com.example.common.Result;
import com.example.entity.User;
import com.example.vo.params.UserPageParams;

import java.util.List;
import java.util.Map;

/**
 * @author shlcm
 */
public interface IUserSevice {
    Result getAllUser(UserPageParams userPageParams);

    //添加用户
    Result addUser(User user)throws Exception;

    //删除用户
    Result deleteUser(List ids);

    Result updateUser(User user)throws Exception;

    Result editUser(Long id);
}
