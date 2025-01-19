package com.wpl.tomarkdownserver.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("SETTING")
@Data
public class SETTING implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Integer id;

    @TableField("CONFIG_NAME")
    private String configName;

    @TableField("CONFIG_VALUE")
    private String configValue;

    @TableField("CREATE_TIME")
    private Date createTime;

    @TableField("REMARK")
    private String REMARK;

}
