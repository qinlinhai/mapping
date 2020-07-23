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

    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功登记的项目信息
     **/
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
    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功汇交的项目信息
     **/
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
    /**
     * 根据项目id查询次项目的详细信息
     * @param projectId
     * @return
     */
    @GetMapping("/selectSuccessRegisterById")
    public ResultData selectSuccessRegisterById(@RequestParam("projectId") Long projectId){
        MappingProject mappingProject = mappingProjectService.selectSuccessRegisterById(projectId);
        return super.selectSuccess("查询项目的详细信息",mappingProject);
    }
    /**
     * @author  qlh
     * @date   2020/7/15
     * @desc
     * 通过项目id查询项目以及附件
     **/
    @GetMapping("/selectProjectandResource")
    public ResultData selectProjectandResource(@RequestParam("projectId") Long projectId){
        List<Map> maps = mappingProjectService.selectProjectandResource(projectId);
        return super.selectSuccess("通过项目id查询项目信息以及附件",maps);
    }
    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 查询汇交结果 通过id
     **/

    @PostMapping("/selectResultCommitById")
    public ResultData selectResultCommitById(@RequestParam("id") Long id){
        ResultCommit resultCommit = resultCommitService.selectResultCommitById(id);
        if(resultCommit!=null){

            return super.selectSuccess("查询汇交结果成功",resultCommit);
        }else{
            return super.selectFailed("查询汇交结果失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     *  查询未审核的项目
     **/
    @GetMapping("/selectNoAudit")
    public ResultData selectNoAudit (@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("projectName") String projectName){
        PageInfo pageInfo = mappingProjectService.selectNoAudit(currentPage, pageSize, projectName);
        return super.selectSuccess("查询未审核的项目",pageInfo);
    }
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询为汇交的项目
     **/
    @GetMapping("/selectNoRemittance")
    public ResultData selectNoRemittance(@RequestParam("currentPage")Integer currentPage,@RequestParam("pageSize")Integer pageSize,
                                         @RequestParam("projectName") String projectName){
        PageInfo pageInfo = mappingProjectService.selectNoRemittance(currentPage, pageSize, projectName);
        return super.selectSuccess("查询未汇交的项目",pageInfo);
    }
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 给项目审核通过
     **/
    @PostMapping("/updateMappingProjectAuditStatus")
    public ResultData updateMappingProjectAuditStatus(@RequestBody MappingProject mappingProject){
        Boolean aBoolean = mappingProjectService.updateMappingProjectAuditStatus(mappingProject);
        if(aBoolean){
            return super.updateSuccess("操作成功");
        }else{
            return super.updateFailed("操作失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     *
     * 查询 已完成 和未完成的 项目类型
     **/
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
    public ResultData selectAdm(@RequestParam("projectType") String projectType,@RequestParam("userid") Integer userid,
                                @RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = mappingProjectService.selectAdm(projectType, userid, pageNumber, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return  super.selectFailed();
        }
    }

//    /**
//     * @Description: 项目管理，添加项目
//     * @Author: Bing
//     * @Date: 2020/7/16 22:06
//     **/
//    @PostMapping("/insertAdm")
//    public ResultData insertAdm(@RequestBody MappingProject mappingProject,@RequestParam Map map){
//        Boolean aBoolean = mappingProjectService.insertAdm(mappingProject, map);
//        if (aBoolean){
//            return super.addSuccess(aBoolean);
//        }else {
//            return super.addFailed();
//        }
//    }

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
    public ResultData deleteAdm(@RequestParam("id") Long id){
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
    public ResultData selectRem(@RequestParam("projectType") String projectType,@RequestParam("userid") Integer userid,
                                @RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize){
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

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据userId查询单位所属项目
     **/

    @GetMapping("/selectProjectByUserId")
    public ResultData selectProjectByUserId(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("userId") Integer userId){
        PageInfo pageInfo = mappingProjectService.selectProjectByUserId(currentPage, pageSize, userId);
        if(pageInfo!=null){
            return super.selectSuccess("根据userId查询单位所属项目成功",pageInfo);
        }else{
            return super.selectFailed("根据userId查询单位所属项目失败");
        }
    }

    /**
     * @Description: 首页测绘项目查询
     * @Author: Bing
     * @Date: 2020/7/18 15:07
     **/
    @PostMapping("/selectShow")
    public ResultData selectShow(@RequestParam("projectType") String projectType,@RequestParam("projectName") String projectName,
                                 @RequestParam("startDate") String startDate ){
        List<MappingProject> mappingProjects = mappingProjectService.selectShow(projectType, projectName, startDate);
        if (mappingProjects != null && !"".equals(mappingProjects)){
            return super.selectSuccess(mappingProjects);
        }else {
            return super.selectFailed();
        }
    }

    @Override
    public BaseService getBaseService() {
        return null;
    }
}
