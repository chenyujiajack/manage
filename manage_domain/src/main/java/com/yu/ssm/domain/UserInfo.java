package com.yu.ssm.domain;

import lombok.Data;

import java.util.List;

//与数据库中的users对应
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

}

