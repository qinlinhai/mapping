package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.model.MappingUnit;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 19:52
 */
@RestController
public class MappingUnitController{

    @Autowired
    private IProjectService iProjectService;
//    /**
//     * @author  qlh
//     * @date   2020/7/21
//     * @desc
//     * 黑名单
//     **/
//    @PostMapping("/selectBlackUnit")
//    public ResultData selectBlackUnit(@RequestParam HashMap hashMap){
//        ResultData resultData = iProjectService.selectBlackUnit(hashMap);
//        return resultData;
//    }
//    /**
//     * @author  qlh
//     * @date   2020/7/21
//     * @desc
//     * 白名单
//     **/
//    @PostMapping("/selectWhiteUnit")
//    public ResultData selectWhiteUnit(@RequestParam HashMap hashMap){
//        ResultData resultData = iProjectService.selectWhiteUnit(hashMap);
//        return resultData;
//    }
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询所有的 单位资质数据
     **/
    @GetMapping("/selectQualification")
    public ResultData selectQualification(){
        return iProjectService.selectQualification();
    }
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 分页查询单位列表
//     **/
//    @PostMapping("/selectAll")
//    public ResultData selectAll(@RequestParam("currentPage") Integer currentPage,
//                         @RequestParam("pageSize") Integer pageSize){
//        return iProjectService.selectAll(currentPage,pageSize);
//    }
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 根据单位的userId查询 特殊人员 技术人员 项目数量
//     **/
//    @GetMapping("/selectPersonByuserId")
//    public ResultData selectPersonByuserId(@RequestParam Integer userId){
//        return iProjectService.selectPersonByuserId(userId);
//    }
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 查询 人员设备信息
//     **/
//    @GetMapping("/selectUnitPersonEquipment")
//    public ResultData selectUnitPersonEquipment(@RequestParam("unitArea") String unitArea){
//        return iProjectService.selectUnitPersonEquipment(unitArea);
//    }
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 分页模糊查询查询所有单位
//     **/
//    @GetMapping("/selectAllUnitVague")
//    public ResultData selectAllUnitVague(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
//            ,@RequestParam("projectName") String unitName){
//        return iProjectService.selectAllUnitVague(currentPage,pageSize,unitName);
//    }
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     *
//     * 分页模糊查询待修改单位列表
//     **/
//    @GetMapping("/selectUnitNoUpdateAudit")
//    public ResultData selectUnitNoUpdateAudit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
//            ,@RequestParam("projectName") String unitName){
//        return iProjectService.selectUnitNoUpdateAudit(currentPage,pageSize,unitName);
//    }
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 分页模糊查询待审核单位列表
//     **/
//    @GetMapping("/selectUnitNoRegister")
//    public ResultData selectUnitNoRegister(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
//            ,@RequestParam("projectName") String unitName){
//        return iProjectService.selectUnitNoRegister(currentPage,pageSize,unitName);
//    }
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据userId查询单位的基本信息
//     **/
//    @PostMapping("/selectUnitByUserId")
//    public ResultData selectUnitByUserId(@RequestBody MappingUnit mappingUnit){
//        return iProjectService.selectUnitByUserId(mappingUnit);
//    }
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 查询关于此单位的附件
//     **/
//    @GetMapping("/selectResourceByUnitId")
//   public ResultData selectResourceByUnitId(@RequestParam("userId") Integer userId){
//        return iProjectService.selectResourceByUnitId(userId);
//    }
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/18
//     * @desc
//     * 双随机抽查单位
//     **/
//    @PostMapping("/selectUnitRandom")
//    public ResultData selectUnitRandom(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
//                                @RequestParam("random") double randmon,@RequestParam("ownedDistrict") String ownedDistrict){
//        return iProjectService.selectUnitRandom(currentPage,pageSize,randmon,ownedDistrict);
//    }
//
//    /**
//     * @author  qlh
//     * @date   2020/7/18
//     * @desc
//     * 根据单位的name level area查询单位
//     **/
//    @GetMapping("/selectUnitBynameAndLevelAndArea")
//    public ResultData selectUnitBynameAndLevelAndArea(@RequestParam("unitName") String unitName,@RequestParam("unitLevel") String unitLevel,
//                                               @RequestParam("unitArea") String unitArea){
//        return iProjectService.selectUnitBynameAndLevelAndArea(unitName,unitLevel,unitArea);
//    }
//
//    /**
//     * @author  qlh
//     * @date   2020/7/18
//     * @desc
//     *  添加一个企业用户
//     **/
//    @PostMapping("/addUnit")
//    public ResultData addUnit(@RequestParam Map map){
//        return iProjectService.addUnit(map);
//    }
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/20
//     * @desc
//     * 修改单位信息
//     **/
//    @PostMapping("/updateUnit")
//    ResultData updateUnit(@RequestBody MappingUnit mappingUnit){
//        return iProjectService.updateUnit(mappingUnit);
//    }


}
