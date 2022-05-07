package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


/**
 * @author shlcm
 */
@Data
@TableName("ms_sys_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer admin;
    private String account;
    private String password;
    private Integer sex;
}
