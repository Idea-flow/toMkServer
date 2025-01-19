package com.wpl.tomarkdownserver.service.daoimpl;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.wpl.tomarkdownserver.entity.MD;
import com.wpl.tomarkdownserver.entity.PIC;
import com.wpl.tomarkdownserver.mapper.MdMapper;
import com.wpl.tomarkdownserver.mapper.PicMapper;
import com.wpl.tomarkdownserver.service.FilelistService;
import com.wpl.tomarkdownserver.service.SettingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @Author wangpenglong
 * @Date 2024/9/3
 * @Description
 */
@Service
@Slf4j
public class FilelistServiceImpl implements FilelistService {

    @Resource
    private PicMapper picMapper;
    @Resource
    private MdMapper mdMapper;
    @Resource
    SettingService settingService;

    @Override
    public JSONObject getFileList(Integer id) {
//        List<Sort.Order> orders = new ArrayList<>();
//        orders.add(new Sort.Order(Sort.Direction.DESC, "createTime"));//设置时间倒序
//        Sort sort = Sort.by(orders);
//        mdMapper.
        List<MD> findbyid = mdMapper.selectList(null);
        JSONObject re = new JSONObject();
        JSONArray jsonArray = new JSONArray();
//
//
        for (MD md : findbyid) {
            JSONObject one_md = new JSONObject();
            one_md.put("title", md.getTITLE());
            one_md.put("pname", md.getPNAME());
            one_md.put("id", md.getId());
            List<String> piclists = picMapper.findbyPname(md.getPNAME());
            one_md.put("pics", piclists);
            jsonArray.add(one_md);
        }
        re.put("data", jsonArray);
        return re;
    }

    @Override
    public void delete(Integer id) {

        MD one = mdMapper.selectById(id);
        String pname = one.getPNAME();
        List<PIC> picbyPname = picMapper.findPicbyPname(pname);
        for (PIC pic : picbyPname) {
            picMapper.deleteById(pic);
            deleteLocalPic(pic.getPATH());
        }
        deleteLocalmd(one.getSavePath());
        mdMapper.deleteById(id);

        log.info("删除文章 ID: " + id);

    }


    //删除本地的markdown文件.
    private void deleteLocalmd(String savePath) {
        File file = new File(savePath);
        if (file.isFile() && file.exists()) {
            boolean delete = file.delete();
            log.info("删除markdown" + savePath +" "+ delete) ;
        } else {
            log.info("删除markdown" + savePath + "错误!!!文件不存在");
        }
    }


    //删除本地的图片.
    private void deleteLocalPic(String path) {
        path = path.substring(41-12,41+4);
        Map<String, String> settings = settingService.getSettings();
        String image_save_path = settings.get("Image_Save_Path");
         image_save_path = image_save_path +"/"+ path;
        System.out.println(image_save_path);
        File file = new File(image_save_path);
        if (file.isFile() && file.exists()) {
            boolean delete = file.delete();
            log.info("删除图片" + path +" "+ delete) ;
        } else {
            log.info("删除图片" + path + "错误!!!文件不存在");
        }
    }

    //写入本地文件
    public  boolean writeTxtFile(String filePath, String content,JSONObject data) throws Exception {
        boolean flag = false;
        FileOutputStream fileOutputStream = null;
        File file = new File(filePath);
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            flag = true;
        } catch (Exception e) {
            System.out.println("文件写入失败！" + e);
        }
        data.put("code", 0);
        return flag;
    }



    @Override
    public JSONObject update(JSONObject data) {
        Integer id = data.getInt("id");
        String context = data.getStr("context");
        String blogUrl = data.getStr("blogUrl");
        String title = data.getStr("title");
        MD one = mdMapper.selectById(id);
        try {
            boolean b = writeTxtFile(one.getSavePath(), context, data);
            log.info("重新写文件 "+ one.getSavePath()+"返回:"+b);
            one.setBlogUrl(blogUrl);
            one.setCONTEXT(context);
            if (!"".equals(title) ) {
                one.setTITLE(title);
            }
            mdMapper.insert(one);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public MD select(Integer id) {
        MD one = mdMapper.selectById(id);
        return one;
    }

    @Override
    public long count() {
        long count = mdMapper.selectCount(null);
        return count;
    }

}
