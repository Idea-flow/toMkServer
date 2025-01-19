package com.wpl.tomarkdownserver.service;


import cn.hutool.json.JSONObject;
import com.wpl.tomarkdownserver.entity.MD;
import org.springframework.stereotype.Service;

/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
@Service
public interface FilelistService {
    JSONObject getFileList(Integer id);

    void delete(Integer id);

    JSONObject update(JSONObject data);

    MD select(Integer id);

    long count();
}
