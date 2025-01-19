package com.wpl.tomarkdownserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wpl.tomarkdownserver.entity.SETTING;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

public interface SettingMapper extends BaseMapper<SETTING> {

    @Select("select * from SETTING st where CONFIG_NAME = #{configName}")
    SETTING findByName(String configName);

    @Transactional
    @Update("update  SETTING   set CONFIG_VALUE = #{configValue}  where  CONFIG_NAME = #{configName}")
    int updateByName(String configName, String configValue);
}
