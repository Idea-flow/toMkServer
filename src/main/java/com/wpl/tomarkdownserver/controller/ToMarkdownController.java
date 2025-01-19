package com.wpl.tomarkdownserver.controller;

import cn.hutool.core.util.IdUtil;
import com.wpl.tomarkdownserver.entity.MarkDown;
import com.wpl.tomarkdownserver.model.CommonResult;
import com.wpl.tomarkdownserver.model.WebSiteContent;
import com.wpl.tomarkdownserver.service.ResolveService;
import com.wpl.tomarkdownserver.service.SaveFileService;
import com.wpl.tomarkdownserver.service.SettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/resolve")
public class ToMarkdownController {




    @Resource
    private SaveFileService saveFileService;

    @Resource
    private SettingService settingService;

    @GetMapping("/getSetting")
    @ResponseBody
    @CrossOrigin
    public CommonResult<Map<String, String>> mark(){

        Map<String, String> settings = settingService.getSettings();

        return CommonResult.success(settings);
    }


    /**
     * 获取文章
     * @param markDown
     * @return
     */
    @PostMapping("/mark")
    @ResponseBody
    @CrossOrigin
    public CommonResult<Map<String, String>> mark(@RequestBody MarkDown markDown, HttpServletRequest request){
        String id = IdUtil.simpleUUID();
        fillUp(markDown,id);
        Map<String,String> resultMap = new HashMap<>();
        WebSiteContent webSiteContent = null;
        try {
            log.info("开始解析 请求地址为: "+markDown.getBlogUrl()+" 请求ID: "+ id);
            webSiteContent = ResolveService.get(markDown);
            resultMap.put("code","0");
            resultMap.put("markdown",webSiteContent.getContent());
            log.info(saveFileService.saveToFile(webSiteContent,id,markDown));
            log.info("解析完成 返回markdown结果 "+ id);
            log.info("-------------------------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code","-1");
            resultMap.put("markdown","");
            resultMap.put("message",e.getMessage());
        }
        return CommonResult.success(resultMap);
    }

    private void fillUp(MarkDown markDown, String id) {
        Map<String, String> settings = settingService.getSettings();
        markDown.setImagePath(settings.get("Image_Save_Path"));
        markDown.setImageName(settings.get("Image_DEFAULT_NAME"));
        markDown.setImageUrl(settings.get("Image_Proxy_Path"));
//        markDown.setImagePath("/Users/wangpenglong/dockerMounts/tomarkdown/pics");
//        markDown.setImageName("1");
//        markDown.setImageUrl("http://127.0.0.1:9998/images");
        markDown.setId(id);
    }


}
