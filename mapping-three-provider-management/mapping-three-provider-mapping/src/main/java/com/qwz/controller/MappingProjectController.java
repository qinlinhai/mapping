package com.qwz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.model.MappingProject;
import com.qwz.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MappingProjectController extends BaseController {
    @Autowired
    private MappingProjectService mappingProjectService;
    @GetMapping("/selectSuccessRegister")
    public ResultData selectSuccessRegister(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                                @RequestParam("userId") Integer userId,@RequestParam("searchName") String searchName) throws Exception {

        PageInfo pageInfo = mappingProjectService.selectSuccessRegister(userId, currentPage, pageSize,searchName);
        ResultData resultData=new ResultData();
        resultData.setData(pageInfo);
        resultData.setMsg("查询成功");
        resultData.setCode("200");
        resultData.setDetail("分页查询所有审核通过的项目");
        return resultData;
    }
    @GetMapping("/selectSuccessRemittance")
    public ResultData selectSuccessRemittance(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                                              @RequestParam("userId") Integer userId,@RequestParam("searchName") String searchName){
        PageInfo pageInfo = mappingProjectService.selectSuccessRemittance(userId, currentPage, pageSize,searchName);
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
        ResultData resultData=new ResultData();
        resultData.setData(mappingProject);
        resultData.setDetail("查询项目的详细信息");
        resultData.setCode("200");
        resultData.setMsg("查询成功");
        return resultData;
    }

}
