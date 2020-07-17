package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseController;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Audit;
import com.qwz.model.MappingProject;
import com.qwz.model.ResultCommit;
import com.qwz.service.AuditService;
import com.qwz.service.MappingProjectService;
import com.qwz.service.ResultCommitService;
import com.qwz.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class MappingProjectController extends CommonController<MappingProject> {
    @Autowired
    private MappingProjectService mappingProjectService;

    @Autowired
    private ResultCommitService resultCommitService;
    @Autowired
    private AuditService auditService;


    @GetMapping("/selectSuccessRegister")
    public ResultData selectSuccessRegister(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                               @RequestParam("searchName") String searchName) throws Exception {

        PageInfo pageInfo = mappingProjectService.selectSuccessRegister(currentPage, pageSize,searchName);
        ResultData resultData=new ResultData();
        resultData.setData(pageInfo);
        resultData.setMsg("查询成功");
        resultData.setCode("200");
        resultData.setDetail("分页查询所有审核通过的项目");
        return resultData;
    }
    @GetMapping("/selectSuccessRemittance")
    public ResultData selectSuccessRemittance(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                                              @RequestParam("searchName") String searchName){
        PageInfo pageInfo = mappingProjectService.selectSuccessRemittance(currentPage, pageSize,searchName);
        ResultData resultData=new ResultData();
        resultData.setData(pageInfo);
        resultData.setMsg("查询成功");
        resultData.setCode("200");
        resultData.setDetail("分页查询所有汇交通过的项目");
        return resultData;
    }

    @GetMapping("/selectSuccessRegisterById")
    public ResultData selectSuccessRegisterById(@RequestParam("projectId") Long projectId){
        MappingProject mappingProject = mappingProjectService.selectSuccessRegisterById(projectId);
        return super.selectSuccess("查询项目的详细信息",mappingProject);
    }

    @GetMapping("/selectProjectandResource")
    public ResultData selectProjectandResource(@RequestParam("projectId") Long projectId){
        List<Map> maps = mappingProjectService.selectProjectandResource(projectId);
        return super.selectSuccess("通过项目id查询项目信息以及附件",maps);
    }


    @PostMapping("/selectResultCommitById")
    public ResultData selectResultCommitById(@RequestParam Long id){
        ResultCommit resultCommit = resultCommitService.selectResultCommitById(id);
        return super.selectSuccess("查询汇交结果",resultCommit);
    }


    @GetMapping("/selectNoAudit")
    public ResultData selectNoAudit (Integer currentPage,Integer pageSize,String projectName){
        PageInfo pageInfo = mappingProjectService.selectNoAudit(currentPage, pageSize, projectName);
        return super.selectSuccess("查询未审核的项目",pageInfo);
    }
    @GetMapping("/selectNoRemittance")
    public ResultData selectNoRemittance(Integer currentPage,Integer pageSize,String projectName){
        PageInfo pageInfo = mappingProjectService.selectNoRemittance(currentPage, pageSize, projectName);
        return super.selectSuccess("查询未汇交的项目",pageInfo);
    }

    @PostMapping("/updateMappingProjectAuditStatus")
    public ResultData updateMappingProjectAuditStatus(@RequestBody MappingProject mappingProject){
        Boolean aBoolean = mappingProjectService.updateMappingProjectAuditStatus(mappingProject);
        if(aBoolean){
            return super.updateSuccess("操作成功");
        }else{
            return super.updateFailed("操作失败");
        }
    }


    @GetMapping("/selectPRojectByType")
    public ResultData selectPRojectByType(){
        List<Map> maps = mappingProjectService.selectPRojectByType();
        if(maps!=null && maps.size()>0){
            return super.selectSuccess("查询项目类型数据成功",maps);
        }else{
            return super.selectFailed("查询项目类型数据失败");
        }
    }


    /**
     * @Description: 项目管理  查询登录用户管理的项目
     * @Author: Bing
     * @Date: 2020/7/16 21:49
     **/
    @PostMapping("/selectAdm")
    public ResultData selectAdm(@RequestParam String projectType,@RequestParam Integer userid,
                                @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        PageInfo pageInfo = mappingProjectService.selectAdm(projectType, userid, pageNumber, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return  super.selectFailed();
        }
    }

    /**
     * @Description: 项目管理，添加项目
     * @Author: Bing
     * @Date: 2020/7/16 22:06
     **/
    @PostMapping("/insertAdm")
    public ResultData insertAdm(@RequestBody MappingProject mappingProject){
        Integer insert = mappingProjectService.insertAdm(mappingProject);
        if (insert > 0){
            return super.addSuccess(insert);
        }else {
            return super.addFailed();
        }
    }

    /**
     * @Description: 项目管理  修改项目
     * @Author: Bing
     * @Date: 2020/7/17 10:44
     **/
    @PostMapping("/updateAdm")
    public ResultData updateAdm(@RequestBody MappingProject mappingProject){
        Integer integer = mappingProjectService.updateAdm(mappingProject);
        if (integer > 0){
            return super.updateSuccess(integer);
        }else {
            return super.updateFailed();
        }
    }

    /**
     * @Description:  项目管理  删除项目
     * @Author: Bing
     * @Date: 2020/7/17 10:46
     **/
    @PostMapping("/deleteAdm")
    public ResultData deleteAdm(@RequestParam Long id){
        Integer integer = mappingProjectService.delectAdm(id);
        if (integer > 0){
            return super.deleteSuccess(integer);
        }else {
            return super.deleteFailed();
        }
    }

    /**
     * @Description: 项目汇交  条件查询
     * @Author: Bing
     * @Date: 2020/7/17 11:04
     **/
    @PostMapping("/selectRem")
    public ResultData selectRem(@RequestParam String projectType,@RequestParam Integer userid,
                                @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        PageInfo pageInfo = mappingProjectService.selectRem(projectType, userid, pageNumber, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return  super.selectFailed();
        }
    }

    /**
     * @Description: 项目汇交  修改项目
     * @Author: Bing
     * @Date: 2020/7/17 11:13
     **/
    @PostMapping("/updateRem")
    public ResultData updateRem(@RequestBody MappingProject mappingProject){
        Integer integer = mappingProjectService.updateRem(mappingProject);
        if (integer > 0){
            return  super.updateSuccess(integer);
        }else {
            return super.updateFailed();
        }
    }


    @Override
    public BaseService getBaseService() {
        return null;
    }
}
