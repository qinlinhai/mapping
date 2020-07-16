package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.mapper.AuditMapper;
import com.qwz.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

@Service
public class AuditService extends BaseService<Audit>{
    @Autowired
    private AuditMapper auditMapper;


    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 添加一条项目登记审核记录
     **/
    public Boolean addMappingProjectAudit(Audit audit){
        Integer insert = super.insert(audit);
        if(insert>0){
            return true;
        }else{
            return false;
        }
    }
}
