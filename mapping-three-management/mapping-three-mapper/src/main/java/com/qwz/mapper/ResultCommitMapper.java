package com.qwz.mapper;

import com.qwz.model.ResultCommit;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ResultCommitMapper extends Mapper<ResultCommit> {
    /**
     * @author  qlh
     * @date   2020/7/15
     * @desc
     * 根据项目id查询 汇交结果信息
     **/
    @Select("select * from t_result_commit where ref_id=#{projectId}")
    List<ResultCommit>  selectResultCommitById(Integer projectId);
}