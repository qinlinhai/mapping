package com.qwz.mapper;

import com.qwz.model.ResultCommit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ResultCommitMapper extends Mapper<ResultCommit> {



    ResultCommit selectOneData(@Param("id") Long id);



    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 根据 成果名称 项目类型  成果日期
     **/
    List<Map> selectResultCommitByNmeAndTypeAndDate(@Param("name") String name, @Param("type") String type, @Param("date") String date);
}