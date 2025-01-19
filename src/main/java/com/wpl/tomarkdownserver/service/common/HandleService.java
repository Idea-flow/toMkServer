package com.wpl.tomarkdownserver.service.common;


import com.wpl.tomarkdownserver.entity.MarkDown;

/**
 * @Author wangpenglong
 * @Date 2024/9/3 16:45
 * @Description
 */
public interface HandleService {

    /**
     * 获取博客内容
     *
     * @param markDown
     * @return
     */
    String getBlogContent(MarkDown markDown);



}
