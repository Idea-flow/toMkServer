package com.wpl.tomarkdownserver.jsoupstudy;

import cn.hutool.http.HttpUtil;
import com.overzealous.remark.Remark;
import com.wpl.tomarkdownserver.entity.MarkDown;
import com.wpl.tomarkdownserver.utils.MarkDownUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @Author wangpenglong
 * @Date 2024/9/4 17:10
 * @Description
 */
public class First {
    public static void main(String[] args) throws IOException {
//         不行
//        Document document= Jsoup.parse(new URL("https://www.yuque.com/biliw/sqnxr0/zil7rpvtuovc86fu"),2000);

        MarkDown markDown = new MarkDown();
        markDown.setBlogUrl("https://blog.csdn.net/qw8431/article/details/139680168");
//        markDown.setBlogUrl("https://blog.csdn.net/weixin_41489136/article/details/123762974");
//        markDown.setBlogUrl("https://www.yuque.com/u1475064/mufu2a/vn5u10ephxh9sau8");
        String website = MarkDownUtil.getUrlOrigin(markDown);

        System.out.println(website);

//        Document document= Jsoup.parse(new URL(markDown.getBlogUrl()),2000);
        Document document= Jsoup.parse(HttpUtil.downloadString(markDown.getBlogUrl(), "utf-8"));
        String title=document.getElementsByTag("title").first().text();//使用标签获取title标签
        System.out.println(title);
        Element article_content = document.getElementById("article_content");

        System.out.println("html"+article_content.html());

        // 转换为 markdown
        Remark remark = new Remark();

        System.out.println("-----------------");

        System.out.println("marketdown:"+remark.convert(article_content.html()));

//
//        Element mainElement = document.getElementById("mainBox");
//
//        // 不是 Markdown，则获取 HTML
//        if(mainElement == null){
//            mainElement = document.getElementById("htmledit_views");
//        }
//
//        String htmlContent = mainElement.getElementById("content_views").html();
//
//        document = Jsoup.parse(htmlContent);
//
//        // 去掉代码块中的行号
//        Elements elements = document.getElementsByTag("pre");
//        if(MarkDownUtil.elementsNotEmpty(elements)){
//
//            Elements preNumbers = null;
//            for(Element element : elements){
//                preNumbers = element.getElementsByClass("pre-numbering");
//                if(MarkDownUtil.elementsNotEmpty(preNumbers)){
//                    for(Element preNumber : preNumbers){
//                        // 删掉换行号
//                        preNumber.remove();
//                    }
//                }
//            }
//        }
//
//        System.out.println(document.html());

    }
}
