package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.model.Principal;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrincipalController {
    @Autowired
    private IProjectService iProjectService;
//
//    /**
//     * @author qlh
//     * @date 2020/7/17
//     * @desc 根据userId 查询 单位负责人信息
//     **/
//    @PostMapping("/selectOneByUserId")
//    public ResultData selectOneByUserId(@RequestParam("userId") Integer userId, @RequestParam("currentPage") Integer currentPage,
//                                        @RequestParam("pageSize") Integer pageSize) {
//        return iProjectService.selectOneByUserId(userId, currentPage, pageSize);
//
//    }
//
//    /**
//     * @author qlh
//     * @date 2020/7/17
//     * @desc 根据负责人id查询负责人基本信息和附件
//     **/
//    @GetMapping("/selectPrincipalEnclosure")
//    public ResultData selectPrincipalEnclosure(@RequestParam("principalId") Long principalId) {
//        return iProjectService.selectPrincipalEnclosure(principalId);
//    }
//
//    /**
//     * @author qlh
//     * @date 2020/7/20
//     * @desc 新增一个负责人信息
//     **/
//    @PostMapping("/addPrincipal")
//    public ResultData addPrincipal(@RequestBody Principal principal) {
//        return iProjectService.addPrincipal(principal);
//    }
//
//    /**
//     * @author qlh
//     * @date 2020/7/20
//     * @desc 修改负责人信息
//     **/
//    @PostMapping("/updatePrincipal")
//    public ResultData updatePrincipal(@RequestBody Principal principal) {
//        return iProjectService.updatePrincipal(principal);
//    }
//
//    /**
//     * @author qlh
//     * @date 2020/7/20
//     * @desc 删除负责人信息
//     **/
//    @PostMapping("/deletePrincipal")
//    public ResultData deletePrincipal(@RequestBody Principal principal) {
//        return iProjectService.deletePrincipal(principal);
//    }
}
