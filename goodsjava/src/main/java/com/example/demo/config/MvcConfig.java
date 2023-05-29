package com.example.demo.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description springMvc配置类
 * @Author 李帅
 * @Date
 * @Version 1.0
 **/
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Value("${blogs.file.savePath}")
    private String savePath;



    /**
     * @Description 配置静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:"+savePath);
    }


}
