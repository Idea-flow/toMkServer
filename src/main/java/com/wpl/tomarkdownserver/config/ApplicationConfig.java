package com.wpl.tomarkdownserver.config;


import com.wpl.tomarkdownserver.entity.SETTING;
import com.wpl.tomarkdownserver.mapper.SettingMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.Resource;

/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
@Slf4j
@Configuration
public class ApplicationConfig implements WebMvcConfigurer, InitializingBean {
    @Resource
    private SettingMapper settingMapper;

    public  String dynamicAddress;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+dynamicAddress);
        log.info("图片服务器映射成功");

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        SETTING set = settingMapper.findByName("Image_Save_Path");
        String configValue = set.getConfigValue();
//        String configValue = "/Users/wangpenglong/dockerMounts/tomarkdown/pics";
        //少/的加/
        if (!configValue.endsWith("/")) {
            configValue += "/";
        }
        dynamicAddress= configValue;
        log.info("加载用户图片保存路径:"+dynamicAddress);
    }
}
