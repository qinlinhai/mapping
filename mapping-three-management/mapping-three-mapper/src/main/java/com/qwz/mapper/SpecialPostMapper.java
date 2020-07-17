package com.qwz.mapper;

import com.qwz.model.SpecialPost;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecialPostMapper extends Mapper<SpecialPost> {

    /**
     * @Description: 根据userid查询特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/17 16:17
     **/
    List<SpecialPost> selectSpecial(@Param("userid") Integer userid);

    /**
     * @Description: 根据id查询特殊人员基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:31
     **/
    List<SpecialPost> selectIdSpecial(@Param("id") Long id);
}