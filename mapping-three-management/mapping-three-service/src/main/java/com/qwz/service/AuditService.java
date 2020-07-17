package com.qwz.service;

import com.github.pagehelper.PageInfo;
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

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据单位id查询单位审核记录
     **/
    public PageInfo selectUnitAuditByUnitId(Integer currentPage,Integer pageSize,Long unitId){
        if(currentPage != null && pageSize!=null){
            List<Audit> audits = auditMapper.selectUnitAuditByUnitId(unitId);
            if(audits!=null){
                PageInfo<Audit> auditPageInfo = new PageInfo<Audit>(audits);
                if(auditPageInfo!=null){
                    return auditPageInfo;
                }else{
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页
     * 根据业务编号查询类型为项目登记审核的审核记录
     **/
    public PageInfo selectProjectAuditByRefId(Long refId,Integer currentPage,Integer pageSize){
        if(currentPage!=null && pageSize!=null){
            if(refId!=null){
                List<Audit> audits = auditMapper.selectProjectAuditByRefId(refId);
                if(audits!=null){
                    PageInfo<Audit> auditPageInfo = new PageInfo<Audit>(audits);
                    if(auditPageInfo!=null){
                        return auditPageInfo;
                    }else{
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页
     * 根据业务编号查询类型为项目汇交审核的审核记录
     **/

    public PageInfo selectProjectRemittanceByRefId(Long refId,Integer currentPage,Integer pageSize){
        if(currentPage!=null && pageSize!=null){
            List<Audit> audits = auditMapper.selectProjectRemittanceByRefId(refId);
            if(audits!=null){
                PageInfo<Audit> auditPageInfo = new PageInfo<Audit>(audits);
                if(auditPageInfo!=null){
                    return auditPageInfo;
                }else{
                    return null;
                }
            }

        }
        return null;
    }
}
