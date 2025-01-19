package com.wpl.tomarkdownserver.service;

import com.wpl.tomarkdownserver.entity.MarkDown;
import com.wpl.tomarkdownserver.model.WebSiteContent;
import com.wpl.tomarkdownserver.service.resolve.*;
import com.wpl.tomarkdownserver.utils.MarkDownUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
@Slf4j
public class ResolveService {
    static HashMap<String, MarkDownService> serviceMap = new HashMap<>();

    private static final String WEIXIN = "weixin";
    private static final String CSDN = "csdn";
    private static final String CSDN_BLOG = "cnblogs"; // 目前没有用到
    private static final String ZHIHU = "zhihu";
    private static final String JUEJIN = "juejin";
    private static final String SEGMENTFAULT = "segmentfault";
    private static final String JIANSHU = "jianshu";
    private static final String V_2_EX = "v2ex";   // 待测试
    private static final String YU_QUE = "yuque";

    private static final String LINUX_DO = "linux";   // 待测试



    public static WebSiteContent get (MarkDown markDown){
        String website = MarkDownUtil.getUrlOrigin(markDown);
        initMap(website);
        return  serviceMap.get(website)
                .getBlogContent(markDown);

    }

    private static void initMap(String website) {
        if (!serviceMap.containsKey(website)) {
            log.info("Init MarkdownService for {}" ,website);
            if (WEIXIN.equals(website)) {
                serviceMap.put(website, new WeiXinHandleServiceImpl());

            } else if (CSDN.equals(website)) {
                serviceMap.put(website, new CSDNHandleServiceImpl());
            } else if (CSDN_BLOG.equals(website)) {
                serviceMap.put(website, new CsdnBlogHandleServiceImpl());
            } else if (JUEJIN.equals(website)) {
                serviceMap.put(website,new JuejinHandleServiceImpl());
            }else if (YU_QUE.equals(website)) {
                serviceMap.put(website,new YuqueHandleServiceImpl());

            } else if (ZHIHU.equals(website)) {
                serviceMap.put(website,new ZhihuHandleServiceImpl());

            }else if (YU_QUE.equals(website)) {
                serviceMap.put(website,new YuqueHandleServiceImpl());

            }else if (LINUX_DO.equals(website)) {
                serviceMap.put(website,new LinuxDoHandleServiceImpl());
            }else if (V_2_EX.equals(website)) {
                serviceMap.put(website,new V2exHandleServiceImpl());
            }
            else {
                log.info("暂时还没有解决方案.");
                throw new RuntimeException("暂时还没有解决方案");
            }
        }
    }
}
