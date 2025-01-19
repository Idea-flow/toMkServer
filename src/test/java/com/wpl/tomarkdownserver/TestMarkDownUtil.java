package com.wpl.tomarkdownserver;

import com.wpl.tomarkdownserver.utils.MarkDownUtil;
import org.junit.jupiter.api.Test;

public class TestMarkDownUtil {

    @Test
    public void testCsdn() {
        String urlOrigin = MarkDownUtil.getUrlOrigin("https://wpl.blog.csdn.net/qw8431/article/details/141401975");
        //请求链接>>> https://wpl.blog.csdn.net/qw8431/article/details/141401975 来源解析为:blog
        System.out.println(urlOrigin);
    }
    @Test
    public void testCsdn2() {
        String urlOrigin = MarkDownUtil.getUrlOrigin("https://blog.csdn.net/qw8431/article/details/141401975");
//        请求链接>>> https://blog.csdn.net/qw8431/article/details/141401975 来源解析为:csdn
        System.out.println(urlOrigin);
    }

    @Test
    public void test32() {
        String urlOrigin = MarkDownUtil.getUrlOrigin("https://linux.do/t/topic/376081");
//        请求链接>>> https://blog.csdn.net/qw8431/article/details/141401975 来源解析为:csdn
        System.out.println(urlOrigin);
    }
}
