package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shlcm
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     *  查询用户信息
     */
    /**
     * @param
     * @return
     */
    List<User> getUserInfo();

    List<User> getAllUserInfo(List<Integer> userIds);

    /**
     * 新增用户
     */
    /**
     *
     * @param user
     * @return
     */
    @Insert("insert into base_info (name, age) values(#{name}, #{age})")
    int addUser(User user);
    int addAllUser(List<User> users);
    /**
     * 删除用户
     */
    /**
     * @param ids
     * description:批量删除用户
     */
    void deleteAll(List<Integer> ids);

    /**
     * 更新用户
     */
    /**
     * @param upuser
     * description:更新用户
     */
    void updated(User upuser);
}
