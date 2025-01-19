package com.wpl.tomarkdownserver.service.daoimpl;


import cn.hutool.json.JSONObject;
import com.wpl.tomarkdownserver.config.ApplicationConfig;
import com.wpl.tomarkdownserver.entity.SETTING;
import com.wpl.tomarkdownserver.entity.UserTemplate;
import com.wpl.tomarkdownserver.mapper.SettingMapper;
import com.wpl.tomarkdownserver.mapper.UserTemplateMapper;
import com.wpl.tomarkdownserver.service.SettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
@Service
@Slf4j
public class SettingServiceImpl implements SettingService {

    @Autowired
    ApplicationConfig applicationConfig;


    @Resource
    private SettingMapper settingMapper;

    @Resource
    UserTemplateMapper userTemplateMapper;



    @Override
    public Map<String, String> getSettings() {
        List<SETTING> list = settingMapper.selectList(null);
        HashMap<String, String> kvMap = new HashMap<>();
        for (SETTING setting : list) {
            String configName = setting.getConfigName();
            String configValue = setting.getConfigValue();
            kvMap.put(configName, configValue);
        }
        return kvMap;
    }




    @Override
    public int setSettings(JSONObject j) {

//    {"User_template_id":"1","MD_Save_Path":"./mds","Image_Save_Path":"./pics"
//            ,"Image_Proxy_Path":"http://localhost:9999/images","Image_DEFAULT_NAME":"pic"}

        Set<Map.Entry<String, Object>> entries = j.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            settingMapper.updateByName(entry.getKey(),entry.getValue().toString());
        }
        return 1;
    }

    @Override
    public UserTemplate getOneUserTemplate(Integer id) {
        return userTemplateMapper.selectById(id);
    }
}
