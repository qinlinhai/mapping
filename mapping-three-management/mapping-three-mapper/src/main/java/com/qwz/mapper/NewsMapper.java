package com.qwz.mapper;

import com.qwz.model.News;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface NewsMapper extends Mapper<News> {

    /**
     * 分页条件模糊查询
     * @return
     */
    List<News> selectNewss(@Param("title") String title);


}