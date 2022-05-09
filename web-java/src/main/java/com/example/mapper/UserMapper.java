package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shlcm
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    //添加用户
    int insert(User user);

    //根据用户名找user
    User find(User user);

    //根据id找user
    User findById(User user);

    List<User> getUserByIds(@Param("ids") List ids);

    //获取所有管理员
    List<User> getAllAdmin();

    //删除用户
    void deleteUser(@Param("ids") List ids);

    //更新用户
    Boolean updateUser(User user);
}
