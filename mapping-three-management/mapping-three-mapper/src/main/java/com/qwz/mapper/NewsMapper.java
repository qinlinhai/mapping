package com.qwz.mapper;

import com.qwz.model.News;
import com.qwz.model.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface NewsMapper extends Mapper<News> {

    /**
     * 分页条件模糊查询
     * @return
     */
    List<News> selectNewss(@Param("title") String title);

    /**
     * @Description: 附件添加成功后，附件表添加一条数据
     * @Author: Bing
     * @Date: 2020/7/18 15:48
     **/
    @Insert("insert into t_resource(id,name,size,path,type,ext_name,ref_biz_id,create_time) values(#{id},#{name},#{size},#{path},#{type},#{ext_name},#{ref_biz_id},#{create_time})")
    int insertResource(Resource resource);
}