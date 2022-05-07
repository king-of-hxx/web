package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.IUserSevice;
import com.example.vo.params.UserPageParams;
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

    @PostMapping("/allUserList")
    public Result getUserList(@RequestBody UserPageParams userPageParams){
       return userService.getAllUser(userPageParams);
    }
}
