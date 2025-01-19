package com.wpl.tomarkdownserver;

import com.wpl.tomarkdownserver.entity.MarkDown;
import com.wpl.tomarkdownserver.model.WebSiteContent;
import com.wpl.tomarkdownserver.service.ResolveService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToMkServerApplicationTests {

    @Test
    void testLinuxDo() {
        MarkDown markDown = new MarkDown();

        markDown.setBlogUrl("https://linux.do/t/topic/376081");
//        markDown.setBlogUrl("https://linux.do/t/topic/312506");

        WebSiteContent webSiteContent = ResolveService.get(markDown);
        System.out.println(webSiteContent.getContent());
    }

    @Test
    void testV2ex() {
        MarkDown markDown = new MarkDown();

        markDown.setBlogUrl("https://www.v2ex.com/t/1103477");

        WebSiteContent webSiteContent = ResolveService.get(markDown);
        System.out.println(webSiteContent.getContent());
    }
}
