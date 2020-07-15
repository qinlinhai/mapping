package com.qwz.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.service.MappingProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mappingProject")
public class MappingProjectController extends BaseController {
    @Autowired
    private MappingProjectService mappingProjectService;
    @RequestMapping("/selectAll")
    public ResultData selectAll(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                                @RequestParam("userId") Integer userId,@RequestParam("searchName") String searchName) throws Exception {

        PageInfo pageInfo = mappingProjectService.selectSuccessRegister(userId, currentPage, pageSize,searchName);
        ResultData resultData=new ResultData();
        resultData.setData(pageInfo);
        resultData.setMsg("查询成功");
        resultData.setCode("200");
        resultData.setDetail("分页查询所有审核通过的项目");
        return resultData;
    }
}
