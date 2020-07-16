package com.qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.model.Audit;
import com.qwz.model.MappingProject;
import com.qwz.service.AuditService;
import com.qwz.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuditController extends BaseController{

    @Autowired
    private AuditService auditService;
    @Autowired
    private MappingProjectService mappingProjectService;
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 项目登记审核
     **/
    @PostMapping("/auditMappingProjectRegister")
    public ResultData auditMappingProjectRegister(Audit audit, @RequestParam("id") Long id,@RequestParam("auditStatus") Integer auditStatus){
        Boolean aBoolean = auditService.addMappingProjectAudit(audit);
        MappingProject mappingProject = new MappingProject();
        mappingProject.setId(id);
        mappingProject.setAuditStatus(auditStatus);
        Boolean aBoolean1 = mappingProjectService.updateMappingProjectAuditStatus(mappingProject);
        if(aBoolean && aBoolean1){
            return super.updateSuccess("项目登记审核操作成功");
        }else{
            return super.updateFailed("项目登记审核操作失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 项目汇交审核
     **/
    @PostMapping("/auditMappingProjectRemittance")
    public ResultData auditMappingProjectRemittance(Audit audit, @RequestParam("id") Long id,@RequestParam("resultStatus") Integer resultStatus){
        Boolean aBoolean = auditService.addMappingProjectAudit(audit);
        MappingProject mappingProject = new MappingProject();
        mappingProject.setId(id);
        mappingProject.setResultsStatus(resultStatus);
        Boolean aBoolean1 = mappingProjectService.updateMappingProjectAuditStatus(mappingProject);
        if(aBoolean && aBoolean1){
            return super.updateSuccess("项目汇交审核操作成功");
        }else{
            return super.updateFailed("项目汇交审核操作失败");
        }
    }


}
