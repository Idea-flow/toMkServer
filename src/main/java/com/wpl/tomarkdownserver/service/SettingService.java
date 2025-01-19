package com.wpl.tomarkdownserver.service;



import cn.hutool.json.JSONObject;
import com.wpl.tomarkdownserver.entity.UserTemplate;

import java.util.Map;

/**
 * @Author wangpenglong
 * @Date 2024/9/3 16:05
 * @Description
 */
public interface SettingService {
    Map<String,String> getSettings();
    int setSettings(JSONObject j);
    UserTemplate getOneUserTemplate(Integer id);

}
