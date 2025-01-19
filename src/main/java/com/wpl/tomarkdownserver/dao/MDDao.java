package com.wpl.tomarkdownserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wpl.tomarkdownserver.entity.MD;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MDDao extends BaseMapper<MD> {

    @Select("select * from MD md where md.ID  =#{id} ")
    List<MD> findbyid(Integer id);

    @Transactional
    @Update(value = "update   MD  set CONTEXT = #{context} WHERE ID = #{id} ")
    void update(Integer id, String context);
}
