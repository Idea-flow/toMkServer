package com.wpl.tomarkdownserver.service.resolve;

import com.wpl.tomarkdownserver.entity.MarkDown;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
public class WeiXinHandleServiceImpl extends MarkDownService {

    @Override
    protected Document getHtmlContent(MarkDown markDown, Document document) {
        Element element = document.getElementById("js_content");
        return Jsoup.parse(element.html());
    }
}
