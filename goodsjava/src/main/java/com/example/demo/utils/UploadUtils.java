package com.example.demo.utils;

import cn.hutool.core.io.FileUtil;

import com.example.demo.config.UploadFileConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description 上传文件工具类
 * @Author 李帅
 * @Date
 * @Version 1.0
 **/
@Component
public class UploadUtils {
    // 初始化配置文件
    private static UploadFileConfig config;

    @Resource
    private UploadFileConfig uConfig;

    @PostConstruct
    public void init() {
        config = uConfig;
    }

    public static String upload(MultipartFile file){
        // 获得上传文件的名称
        String fileName = file.getOriginalFilename();
        // 保存文件的唯一性
        String uuid = UUID.randomUUID().toString().replace("-","");
        // 生成的文件和uuid进行拼接
        String newFileName = uuid + "-" + fileName;
        File newFile = new File(config.getSavePath(), newFileName);
        // 判断是否有这个文件夹
        if(!newFile.exists()){
            FileUtil.mkdir(config.getSavePath());
        }
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config.getUsePath()+newFileName;
    }
}
