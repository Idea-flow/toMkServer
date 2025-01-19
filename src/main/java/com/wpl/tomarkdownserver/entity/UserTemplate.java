package com.wpl.tomarkdownserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("USER_TEMPLATE")
public class UserTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId("ID")
    private Integer ID;

    @TableField("HEADER")
    private String HEADER;

    @TableField("BOTTOM")
    private String BOTTOM;

}
