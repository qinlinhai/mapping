package com.qwz.mapper;

import com.qwz.model.Audit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AuditMapper extends Mapper<Audit>{
        /**
         * @author  qlh
         * @date   2020/7/15
         * @desc
         * 根据业务编号查询类型为项目登记审核的审核记录
         **/
        @Select("select * from t_audit where name='项目登记审核' and ref_id=#{refId}")
        List<Audit> selectProjectAuditByRefId(@Param("refId") Integer refId);
        @Select("select * from t_audit where name='项目成果汇交' and ref_id=#{refId}")
        List<Audit> selectProjectRemittanceByRefId(@Param("refId") Integer refId);
}

