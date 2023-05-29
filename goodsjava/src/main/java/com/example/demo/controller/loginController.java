package com.example.demo.controller;
import cn.hutool.core.collection.CollUtil;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.Response;
import com.example.demo.web.controller.BaseController;
import com.example.demo.web.page.TableDataInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/system")
@Slf4j
public class loginController  extends BaseController {

    @Autowired
    private UserMapper userMapper;
    /*
     **登录
     */
    @PostMapping(value="/login")
    @ResponseBody
    public Response login(String userName, String password){
        User user = userMapper.selectByName(userName,password);
        if(user == null||!(password).equals(user.getPassword())){
            return Response.failed("没有此用户或密码错误");
        }

        return Response.success(user);
    }
    /*
    **注册
    */
    @PostMapping(value="/register")
    @ResponseBody
    public Response register(User user){

        user.setLoginName(user.getUserName());
        List<User> user1 = userMapper.selectList(user);
        if(user1.size() > 0) {
            return Response.failed("注册失败");
        }
        int i = userMapper.insertUserAll(user);
        if(i < 1) {
            return Response.failed("注册失败");
        }
        return Response.success(i);
    }


    /*
     **修改用户表数据
     */
    @PostMapping (value="/updateUserAll")
    @ResponseBody
    public Response updateUserAll(User user){

         int a= userMapper.updateUserAll(user);
        if(a != 1){
            return Response.failed("修改失败");
        }
        return Response.success();
    }

    /*
     **查询用户表数据
     */
    @PostMapping (value="/selectList")
    @ResponseBody
    public TableDataInfo selectList(User user){

        startPage();
        List<User> user1 = userMapper.selectList(user);

        return getDataTable(user1);
    }

    /*
     **根据用户id删除用户表数据
     */
    @PostMapping (value="/deleteUserById")
    @ResponseBody
    public Response deleteUserById(String userId){

        int a = userMapper.deleteUserById(userId);
        if(a != 1){
            return Response.failed("删除失败");
        }
        return Response.success();

    }



}
