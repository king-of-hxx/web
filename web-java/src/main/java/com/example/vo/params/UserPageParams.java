package com.example.vo.params;

import lombok.Data;

@Data
public class UserPageParams {
    private int currentPage;

    private int pageSize;

    private String keyWord;
}
