package com.wpl.tomarkdownserver.controller;


import cn.hutool.json.JSONObject;
import com.wpl.tomarkdownserver.entity.MD;
import com.wpl.tomarkdownserver.pojo.CommonResult;
import com.wpl.tomarkdownserver.service.FilelistService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@CrossOrigin
@Controller
@RequestMapping("/blog")
public class PageController {
    @Resource
    private FilelistService filelistService;

    @RequestMapping("/")
    public String toFirstHtml(){
        return "index";
    }

    @RequestMapping("/filelist")
    @ResponseBody
    public JSONObject filelist(@RequestBody JSONObject data) {
        return filelistService.getFileList(data.getInt("id"));
    }


    //delete
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Integer delete(@PathVariable("id")Integer id) {
         filelistService.delete(id);
         return 1;
    }


    //update
    @RequestMapping("/update")
    @ResponseBody
    public JSONObject update(@RequestBody JSONObject data) {
        return filelistService.update(data);
    }

    //select
    @RequestMapping("/select/{id}")
    @ResponseBody
    public CommonResult<MD> select(@PathVariable("id")Integer id) {
        return CommonResult.success(filelistService.select(id));
    }




    //count
    @RequestMapping("/count")
    @ResponseBody
    public long count() {
        return filelistService.count();
    }
}
