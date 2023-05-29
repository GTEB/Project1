package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description 枚举返回状态
 * @Author 李帅
 * @Date
 * @Version 1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode {

    SUCCESS("SUCCESS", "请求成功"),
    FAILED("FAILED", "服务器错误"),
    INVALID_ARGUMENT("INVALID_ARGUMENT", "参数错误");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
