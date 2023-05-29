package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description 统一响应对象
 * @Author 李帅
 * @Date
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    private String code;//错误类型

    private String message;//错误信息

    private T data;//数据

    public static <T>Response<T> success (){
        Response<T> res = new Response<T>();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMessage(ResultCode.SUCCESS.getMessage());
        return res;
    }

    public static <T>Response<T> success (T Object){
        Response<T> res = new Response<T>();
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMessage(ResultCode.SUCCESS.getMessage());
        res.setData(Object);
        return res;
    }

    public static <T>Response<T> failed(){
        Response<T> res = new Response<T>();
        res.setCode(ResultCode.FAILED.getCode());
        res.setMessage(ResultCode.FAILED.getMessage());
        return res;
    }

    public static <T>Response<T> failed(ResultCode code){
        Response<T> res = new Response<T>();
        res.setCode(code.getCode());
        res.setMessage(code.getMessage());
        return res;
    }

    public static <T>Response<T> failed(String message){
        Response<T> res = new Response<T>();
        res.setCode(ResultCode.FAILED.getCode());
        res.setMessage(message);
        return res;
    }

    public static <T>Response<T> failed(String code, String message){
        Response<T> res = new Response<T>();
        res.setCode(code);
        res.setMessage(message);
        return res;
    }
}
