package com.example.vo;

import lombok.Data;

import java.util.List;

/**
 * @author shlcm
 */
@Data
public class UserVoList<T> {
    private List<T> userList;
    private long total;
}
