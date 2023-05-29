package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;


public interface UserMapper{
    User selectByName(String userName,String password);


    int insertUserAll(User user);

    int updateUserAll(User user);


    int deleteUserById(String userId);

    List<User> selectList(User user);


}
