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
}
