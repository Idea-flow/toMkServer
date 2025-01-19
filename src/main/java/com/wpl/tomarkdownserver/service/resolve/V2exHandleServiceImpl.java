package com.wpl.tomarkdownserver.service.resolve;

import com.wpl.tomarkdownserver.entity.MarkDown;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class V2exHandleServiceImpl extends MarkDownService {

    @Override
    protected Document getHtmlContent(MarkDown markDown, Document document) {
        Elements topic_content = document.getElementsByClass("topic_content");

        markDown.setBlogTitle(document.getElementsByTag("H1").html());
        return Jsoup.parse(topic_content.html());
    }
}
