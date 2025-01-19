package com.wpl.tomarkdownserver.service;


import com.wpl.tomarkdownserver.entity.MarkDown;

import java.io.IOException;

/**
 * @Author wangpenglong
 * @Date 2024/9/3 16:28
 * @Description
 */
public interface SaveFileService {
    String saveToFile(String result, String id, MarkDown markDown) throws IOException;
    void saveToDatabase(String result,String id,String savePath,MarkDown markDown) throws IOException;
    void saveImagePath(String path);
}
