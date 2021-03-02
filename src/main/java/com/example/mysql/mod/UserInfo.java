package com.example.mysql.mod;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author liu
 * @version 1.0
 * @description
 * @createDate 2021/3/2
 */
@Data
public class UserInfo {

    private Integer userId;

    private String userName;

    private String createTime;

    private String updateTime;

    private String pass;

    private String department;

    private String phone;

    private String email;

    private String idNum;

    private String realName;

    private String roleName;

    private Integer type;

    private Integer status;


}
