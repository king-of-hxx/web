package com.example.controller;

import com.example.common.Result;
import com.example.service.LoginService;
import com.example.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shlcm
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginServiceImpl;

    @PostMapping("/login")
    public Result login(@RequestBody LoginParams loginParams){
        return loginServiceImpl.login(loginParams);
    }
}
