package com.wpl.tomarkdownserver.service.resolve;

import com.wpl.tomarkdownserver.entity.MarkDown;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinuxDoHandleServiceImpl extends MarkDownService {

    @Override
    protected Document getHtmlContent(MarkDown markDown, Document document) {
//        Elements topic_content = document.getElementsByClass("post");
        Element topic_content = document.getElementsByClass("post").get(0);
        markDown.setBlogTitle(document.getElementsByTag("H1").get(0).text());
        return Jsoup.parse(topic_content.html());
    }
}
