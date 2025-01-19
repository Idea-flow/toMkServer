package com.wpl.tomarkdownserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@TableName("PIC")
@Data
public class PIC implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Integer id;

    @TableField("PNAME")
    private String PNAME;
    @TableField("PATH")
    private String PATH;
    @TableField("CREATE_TIME")
    private Date createTime;

}
