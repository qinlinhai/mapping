package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;

import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.MappingUnit;
import com.qwz.service.MappingUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MappingUnitController extends CommonController<MappingUnit> {


    @Autowired
    private MappingUnitService mappingUnitService;
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询所有的 单位资质数据
     **/
    @GetMapping("/selectQualification")
    public ResultData selectQualification(){
        List<Map> maps = mappingUnitService.selectQualification();
        if(maps.size()>0 && maps!=null){
            return super.selectSuccess("单位资质数据查询",maps);
        }else{
            return super.selectFailed();
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 分页查询单位列表
     **/
    @PostMapping("/selectAll")
    public ResultData selectAll(@RequestParam("currentPage") Integer currentPage,
                                @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = mappingUnitService.selectAll(currentPage, pageSize);
        if(pageInfo!=null){
            return super.selectSuccess("查询单位列表成功",pageInfo);
        }else{
            return super.selectFailed("查询单位列表失败");
        }

    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 根据单位的userId查询 特殊人员 技术人员 项目数量
     **/
    @GetMapping("/selectPersonByuserId")
    public ResultData selectPersonByuserId(@RequestParam Integer userId){
        List<Map> maps = mappingUnitService.selectPersonByuserId(userId);
        if(maps!=null && maps.size()>0){
            return super.selectSuccess("查询人员成功",maps);
        }else{
            return super.selectFailed("查询人员失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询 人员设备信息
     **/
    @GetMapping("/selectUnitPersonEquipment")
    public ResultData selectUnitPersonEquipment(@RequestParam("unitArea") String unitArea){
        List<Map> maps = mappingUnitService.selectUnitPersonEquipment(unitArea);
        if(maps!=null && maps.size()>0){
            return super.selectSuccess("查询人员设备信息成功",maps);
        }else{
            return super.selectFailed("查询人员设备信息失败");
        }
    }

    /**
     * @Description: 查询白名单
     * @Author: Bing
     * @Date: 2020/7/16 11:46
     **/
    @PostMapping("/selectWhiteUnit")
    public ResultData selectWhiteUnit(@RequestParam HashMap hashMap){
        PageInfo pageInfo = mappingUnitService.selectWhiteUnit(hashMap);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 查询黑名单
     * @Author: Bing
     * @Date: 2020/7/16 11:46
     **/
    @PostMapping("/selectBlackUnit")
    public ResultData selectBlackUnit(@RequestParam HashMap hashMap){
        PageInfo pageInfo = mappingUnitService.selectBlackUnit(hashMap);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return null;
    }
}
