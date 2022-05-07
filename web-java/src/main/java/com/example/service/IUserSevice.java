package com.example.service;

import com.example.common.Result;
import com.example.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author shlcm
 */
public interface IUserSevice {
    Result getUserInfo();

    Result getAllUserInfo(List<Integer> userIds);

    Result addUser(User user);

    Result addAllUser(List<User> users);

    Result deleteAll(List<Integer> ids);

    Result update(User user);

    Result updateName(Map<String,Object> userN);

    Result updatexml(User upuser);
}
