package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.model.Audit;

import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private IProjectService iProjectService;
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 项目登记审核
     **/
    @PostMapping("/auditMappingProjectRegister")
    public ResultData auditMappingProjectRegister(@RequestBody Audit audit, @RequestParam("id") Long id, @RequestParam("auditStatus") Integer auditStatus){
        return iProjectService.auditMappingProjectRegister(audit,id,auditStatus);
    }
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 项目汇交审核
     **/
    @PostMapping("/auditMappingProjectRemittance")
    public ResultData auditMappingProjectRemittance(@RequestBody Audit audit, @RequestParam("id") Long id,@RequestParam("resultStatus") Integer resultStatus){
        return iProjectService.auditMappingProjectRemittance(audit,id,resultStatus);
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
        return iProjectService.selectUnitAuditByUnitId(currentPage,pageSize,unitId);
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 审核待修改审核
     **/
    @PostMapping("/updateUnitStatus")
    public ResultData updateUnitStatus(@RequestBody Audit audit,@RequestParam("unitId") Long unitId,@RequestParam("auditStatus") Integer auditStatus){
        return iProjectService.updateUnitStatus(audit,unitId,auditStatus);
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
        return iProjectService.selectProjectAuditByRefId(refId,currentPage,pageSize);
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
        return iProjectService.selectProjectRemittanceByRefId(refId,currentPage,pageSize);
    }
}
