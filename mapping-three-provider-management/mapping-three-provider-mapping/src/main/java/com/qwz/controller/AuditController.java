package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseController;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Audit;
import com.qwz.model.MappingProject;
import com.qwz.model.MappingUnit;
import com.qwz.service.AuditService;
import com.qwz.service.MappingProjectService;
import com.qwz.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuditController extends CommonController<Audit> {

    @Autowired
    private AuditService auditService;
    @Autowired
    private MappingProjectService mappingProjectService;
    @Autowired
    private MappingUnitService mappingUnitService;
    @Override
    public BaseService<Audit> getBaseService() {
        return null;
    }
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
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据单位id查询单位审核记录
     **/
    @GetMapping("/selectUnitAuditByUnitId")
    public ResultData selectUnitAuditByUnitId(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
                                              @RequestParam("unitId") Long unitId){
        PageInfo pageInfo = auditService.selectUnitAuditByUnitId(currentPage, pageSize, unitId);
        if(pageInfo!=null){
            return super.selectSuccess("根据单位id查询单位审核记录成功",pageInfo);
        }else{
            return super.selectFailed();
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 审核待修改审核
     **/
    @PostMapping("/updateUnitStatus")
    public ResultData updateUnitStatus(Audit audit,@RequestParam("unitId") Long unitId,@RequestParam("auditStatus") Integer auditStatus){
        Boolean aBoolean = mappingUnitService.updateUnitStatus(unitId, auditStatus);
        Boolean aBoolean1 = auditService.addMappingProjectAudit(audit);
        if(aBoolean && aBoolean1){
            return super.updateSuccess();
        }else{
            return super.updateFailed();
        }

    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据业务编号查询类型为项目登记审核的审核记录
     **/
    @GetMapping("/selectProjectAuditByRefId")
    public ResultData selectProjectAuditByRefId(@RequestParam("refId") Long refId,@RequestParam("currentPage") Integer currentPage,
                                                 @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = auditService.selectProjectAuditByRefId(refId, currentPage, pageSize);
        if(pageInfo!=null){
            return super.selectSuccess("查询项目登记成功",pageInfo);
        }else{
            return super.selectFailed("查询项目登记失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据业务编号查询类型为项目汇交审核的审核记录
     **/
    @GetMapping("/selectProjectRemittanceByRefId")
    public ResultData selectProjectRemittanceByRefId(@RequestParam("refId") Long refId,@RequestParam("currentPage") Integer currentPage,
                                                @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = auditService.selectProjectRemittanceByRefId(refId, currentPage, pageSize);
        if(pageInfo!=null){
            return super.selectSuccess("查询项目汇交成功",pageInfo);
        }else{
            return super.selectFailed("查询项目汇交失败");
        }
    }

}
