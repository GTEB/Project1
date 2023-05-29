package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Description 用户表
 * @Author 李帅
 * @Date
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class User {
    /**
     * 主键
     * uuid
     */

    private Long userId;

    private String password;
    private String userName;
    private String loginName;



}
