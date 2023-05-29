package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 上传文件配置
 * @Author 李帅
 * @Date
 * @Version 1.0
 **/

@Configuration
@ConfigurationProperties(prefix = "blogs.file")
@Data
public class UploadFileConfig {
    private String savePath;
    private String usePath;
}
