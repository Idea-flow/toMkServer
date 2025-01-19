package com.wpl.tomarkdownserver.entity;

import lombok.Data;



@Data
public class MarkDown {
    private String id;

    private String website;

    private String blogUrl;

    private String imagePath;

    private String imageUrl;

    private String imageName;

//    解析文章的时候存储
    private String blogTitle;


}
