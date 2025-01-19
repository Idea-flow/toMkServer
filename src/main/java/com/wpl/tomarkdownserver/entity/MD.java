package com.wpl.tomarkdownserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("MD")
public class MD implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Integer id;

    @TableField("TITLE")
    private String TITLE;

    @TableField("CONTEXT")
    private String CONTEXT;

    @TableField("PNAME")
    private String PNAME;


    @TableField("SAVE_PATH")
    private String savePath;
    @TableField("BLOG_URL")
    private String blogUrl;

    @TableField("CREATE_TIME")
    private Date createTime;

}
