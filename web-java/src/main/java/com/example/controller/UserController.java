package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.IUserSevice;
import com.example.vo.params.UserPageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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

    //添加用户
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user) throws Exception{
        return userService.addUser(user);
    }

    @PostMapping("/deleteUser")
    public Result deleteUser(@RequestBody List<Integer> ids){
        return userService.deleteUser(ids);
    }

    @PostMapping("/updateUser")
    public Result updateUser(@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }
}
