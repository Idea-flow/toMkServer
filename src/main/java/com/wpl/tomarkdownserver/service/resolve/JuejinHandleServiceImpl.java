package com.wpl.tomarkdownserver.service.resolve;

import com.wpl.tomarkdownserver.entity.MarkDown;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public  class JuejinHandleServiceImpl extends MarkDownService {

    @Override
    protected synchronized Document getHtmlContent(MarkDown markDown, Document document) {
//        Elements article = document.getElementsByClass("article-content");
        Element article = document.getElementById("article-root");
        return Jsoup.parse(article.html().replaceAll("复制代码",""));
    }
}
