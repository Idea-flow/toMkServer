package com.wpl.tomarkdownserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wpl.tomarkdownserver.entity.PIC;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PICDao extends BaseMapper<PIC> {

    @Select("select pic.PATH from PIC pic where pic.PNAME = #{pname} ")
    List<String> findbyPname(String pname);
    @Select("select * from PIC pic where pic.PNAME = #{pname} ")
    List<PIC> findPicbyPname(String pname);
}
