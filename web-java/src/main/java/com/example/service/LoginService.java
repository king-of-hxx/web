package com.example.service;

import com.example.common.Result;
import com.example.vo.params.LoginParams;

public interface LoginService {
    Result login(LoginParams loginParams);
}
