package com.wpl.tomarkdownserver.service.daoimpl;

import cn.hutool.core.util.StrUtil;
import com.wpl.tomarkdownserver.entity.MD;
import com.wpl.tomarkdownserver.entity.MarkDown;
import com.wpl.tomarkdownserver.entity.SETTING;
import com.wpl.tomarkdownserver.mapper.MdMapper;
import com.wpl.tomarkdownserver.mapper.SettingMapper;
import com.wpl.tomarkdownserver.service.SaveFileService;
import com.wpl.tomarkdownserver.utils.MarkDownUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
@Slf4j
@Service
public class SaveFileServiceImpl implements SaveFileService {


    @Resource
    private MdMapper mdMapper;

    @Resource
    private SettingMapper settingMapper;
    @Override
    public String saveToFile(String result, String id, MarkDown markDownm) throws IOException {

        SETTING mdSavePath = settingMapper.findByName("MD_Save_Path");
        System.out.println(mdSavePath);
        //通过此接口,将markdown保存为文本
        File f = new File(mdSavePath.getConfigValue());
        if (!f.exists()) {
            f.mkdirs();
        }
        String filename = MarkDownUtil.generatorFileName();
        File mdFile = new File(f, filename);
        if (!mdFile.exists()) {
            mdFile.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(mdFile);
        outputStream.write(result.getBytes());
        outputStream.close();

        String savepath = mdSavePath.getConfigValue() + "/" + filename;

        saveToDatabase(result, id, savepath,markDownm);
        return "MD文件保存到:"+savepath;
    }

    @Override
    public void saveToDatabase(String result,String id,String savePath,MarkDown markdown) throws IOException {
        if (StrUtil.isBlank(result)) {
            return;
        }
        MD md = new MD();
        md.setCreateTime(new Date());
        md.setCONTEXT(result);
        md.setPNAME(id);
        md.setTITLE(getTitle(result));
        md.setSavePath(savePath);
        md.setBlogUrl(markdown.getBlogUrl());
        mdMapper.insert(md);
        log.info("保存到数据库成功!");
    }

    private String getTitle(String result) {
        int length = result.length();
        if (length < 100) {
            return result.substring(0, length);
        }
        return result.substring(0, 100);
    }

    @Override
    public void saveImagePath(String path) {

    }
}
