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
        List<Audit> selectProjectAuditByRefId(@Param("refId") Long refId);
        List<Audit> selectProjectRemittanceByRefId(@Param("refId") Long refId);


        /**
         * @author  qlh
         * @date   2020/7/17
         * @desc
         * 根据单位id分页查询单位审核记录
         **/
        List<Audit> selectUnitAuditByUnitId(Long unitId);
}

