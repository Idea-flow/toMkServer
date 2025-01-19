package com.wpl.tomarkdownserver.service.resolve;

import com.wpl.tomarkdownserver.entity.MarkDown;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @Author wangpenglong
 * @Date 2024/10/21 16:53
 * @Description
 */
public class ZhihuHandleServiceImpl extends MarkDownService {


    @Override
    protected Document getHtmlContent(MarkDown markDown, Document document) {
        Element root = document.getElementById("root");
        Elements elementsByClass = root.getElementsByClass("Post-RichText");
        if (elementsByClass.size() == 0) {
            //是question
            Elements content = document.getElementsByClass("QuestionAnswer-content");
            Document parse = Jsoup.parse(content.html());
            Elements content_inner = parse.getElementsByClass("RichContent-inner");
            if (content_inner.size() > 0) {
                return Jsoup.parse(content_inner.html());
            } else {
                return Jsoup.parse(content.attr("error","解析知乎页面异常").html());
            }
        }
        return Jsoup.parse(elementsByClass.html());
    }
}
