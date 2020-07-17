package com.qwz.mapper;

import com.qwz.model.Technicist;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TechnicistMapper extends Mapper<Technicist> {

    /**
     * @Description: 根据userid查询技术人员信息
     * @Author: Bing
     * @Date: 2020/7/17 15:58
     **/
    List<Technicist> selectTec(@Param("userid") Integer userid);

    /**
     * @Description: 根据id查询技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/17 16:38
     **/
    List<Technicist> selectOneTec(@Param("id") Long id);
}