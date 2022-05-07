package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.IUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author shlcm
 */
@RestController
@RequestMapping
public class UserController {
    @Autowired
    private IUserSevice userService;

    @GetMapping("/user")
    public Result getUser(){
//       int userId= Integer.parseInt(id);
       return userService.getUserInfo();
    }
}
