package com.wpl.tomarkdownserver.utils;

import com.wpl.tomarkdownserver.entity.MarkDown;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author wangpenglong
 * @Date 2024/9/3 16:30
 * @Description
 */
@Slf4j
public class MarkDownUtil {

    /**
     * 判断 Elements 是否为空
     * @param elements
     * @return
     */
    public static Boolean elementsNotEmpty(Elements elements){
        if(elements != null && elements.size() > 0){
            return true;
        }

        return false;
    }

    /**
     * 获取 图片 file
     *
     * @param imageFilePath
     * @param imageFileName
     * @return
     */
    public static File getImageFile(String imageFilePath,String imageFileName) throws IOException {
       File imageFile =  new File(imageFilePath + File.separator + imageFileName);
       imageFile.createNewFile();
       return imageFile;
    }


    public static String getUrlOrigin(MarkDown markDown) {
        String net = "";
        String url = markDown.getBlogUrl();
        String[] httpsSplit = url.split("://");
        int i = httpsSplit[1].length() - httpsSplit[1].replaceAll("\\.", "").length();
        if (i >= 2) {
            String[] split = httpsSplit[1].split("\\.");
            net = split[1];
        } else {
            String[] split = httpsSplit[1].split("\\.");
            net = split[0];
        }
        log.info("请求链接>>> {} 来源解析为:{}",url,net);
        markDown.setWebsite(net);
        return net;
    }
    public static String getUrlOrigin(String url) {
        String net = "";
        String[] httpsSplit = url.split("://");
        int i = httpsSplit[1].length() - httpsSplit[1].replaceAll("\\.", "").length();
        String[] split = httpsSplit[1].split("\\.");
        net = split[i-1];
        log.info("请求链接>>> {} 来源解析为:{}",url,net);
        return net;
    }
    public static String generatorFileName(String title) {
        String filename = UUID.randomUUID().toString().split("-")[0]+title+".md";
        return filename;
    }
}
