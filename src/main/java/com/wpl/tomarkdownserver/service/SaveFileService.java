package com.wpl.tomarkdownserver.service;


import com.wpl.tomarkdownserver.entity.MarkDown;
import com.wpl.tomarkdownserver.model.WebSiteContent;

import java.io.IOException;

/**
 * @Author wangpenglong
 * @Date 2024/9/3 16:28
 * @Description
 */
public interface SaveFileService {
    String saveToFile(WebSiteContent webSiteContent, String id, MarkDown markDown) throws IOException;
    void saveToDatabase(WebSiteContent webSiteContent,String id,String savePath,MarkDown markDown) throws IOException;
    void saveImagePath(String path);
}
