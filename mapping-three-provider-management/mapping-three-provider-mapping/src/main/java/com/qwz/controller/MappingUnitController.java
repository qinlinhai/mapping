package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;

import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Audit;
import com.qwz.model.MappingUnit;
import com.qwz.service.AuditService;
import com.qwz.service.MappingUnitService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MappingUnitController extends CommonController<MappingUnit> {


    @Autowired
    private MappingUnitService mappingUnitService;
    @Autowired
    private AuditService auditService;
    @Override
    public BaseService<MappingUnit> getBaseService() {
        return null;
    }
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
    public ResultData selectPersonByuserId(@RequestParam("userId") Integer userId){
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
    public ResultData selectWhiteUnit(@RequestBody HashMap hashMap){
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
    public ResultData selectBlackUnit(@RequestBody HashMap hashMap){
        PageInfo pageInfo = mappingUnitService.selectBlackUnit(hashMap);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页模糊查询查询所有单位
     **/
    @GetMapping("/selectAllUnitVague")
    public ResultData selectAllUnitVague(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
    ,@RequestParam("projectName") String unitName){
        try {
            PageInfo pageInfo = mappingUnitService.selectAllUnitVague(currentPage, pageSize, unitName);
            if(pageInfo!=null && !"".equals(pageInfo)){

                return super.selectSuccess("分页模糊查询所有单位成功",pageInfo);
            }else{
                return super.selectFailed("分页模糊查询所有单位失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     *
     * 分页模糊查询待修改单位列表
     **/
    @GetMapping("/selectUnitNoUpdateAudit")
    public ResultData selectUnitNoUpdateAudit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
            ,@RequestParam("projectName") String unitName){
        try {
            PageInfo pageInfo = mappingUnitService.selectUnitNoUpdateAudit(currentPage, pageSize, unitName);
            if(pageInfo!=null && !"".equals(pageInfo)){
                return super.selectSuccess("分页模糊查询待修改单位列表成功",pageInfo);
            }else{
                return super.selectFailed("分页模糊查询待修改单位列表失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页模糊查询待审核单位列表
     **/
    @GetMapping("/selectUnitNoRegister")
    public ResultData selectUnitNoRegister(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
            ,@RequestParam("projectName") String unitName){
        try {
            PageInfo pageInfo = mappingUnitService.selectUnitNoRegister(currentPage, pageSize, unitName);
            if(pageInfo!=null && !"".equals(pageInfo)){
                return super.selectSuccess("分页模糊查询待审核单位列表成功",pageInfo);
            }else{
                return super.selectFailed("分页模糊查询待审核单位列表失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   /**
    * @author  qlh
    * @date   2020/7/17
    * @desc
    * 根据userId查询单位的基本信息
    **/
   @PostMapping("/selectUnitByUserId")
   public ResultData selectUnitByUserId(@RequestBody MappingUnit mappingUnit){
       MappingUnit mappingUnit1 = mappingUnitService.selectUnitByUserId(mappingUnit);
       if(mappingUnit1!=null && !"".equals(mappingUnit1)){
           return super.selectSuccess("根据userId查询单位的基本信息成功",mappingUnit1);
       }else{
           return super.selectFailed("根据userId查询单位的基本信息失败");
       }
   }

   /**
    * @author  qlh
    * @date   2020/7/17
    * @desc
    * 查询关于此单位的附件
    **/
   @GetMapping("/selectResourceByUnitId")
   public ResultData selectResourceByUnitId(@RequestParam("userId") Integer userId){
       List<Map> maps = mappingUnitService.selectResourceByUnitId(userId);
       if(maps!=null && maps.size()>0){
           return super.selectSuccess("查询单位附件成功",maps);
       }else{
           return super.selectFailed("查询单位附件失败");
       }
   }


    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 双随机抽查单位
     **/
    @PostMapping("/selectUnitRandom")
    public ResultData selectUnitRandom(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("random") double randmon,@RequestParam("ownedDistrict") String ownedDistrict){
        PageInfo pageInfo = mappingUnitService.selectUnitRandom(currentPage, pageSize, randmon,ownedDistrict);
        if(pageInfo!=null){
            return super.selectSuccess("双随机抽查单位成功",pageInfo);
        }else{
            return super.selectFailed("双随机抽查单位失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 根据单位的name level area查询单位
     **/
    @GetMapping("/selectUnitBynameAndLevelAndArea")
    public ResultData selectUnitBynameAndLevelAndArea(@RequestParam("unitName") String unitName,@RequestParam("unitLevel") String unitLevel,
                                                      @RequestParam("unitArea") String unitArea){
        List<MappingUnit> mappingUnits = mappingUnitService.selectUnitBynameAndLevelAndArea(unitName, unitLevel, unitArea);
        if(mappingUnits!=null&&mappingUnits.size()>0){
            return super.selectSuccess("根据单位的name level area查询单位成功",mappingUnits);
        }else{
            return super.selectFailed("根据单位的name level area查询单位失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     *  添加一个企业用户
     **/
    @PostMapping("/addUnit")
    public ResultData addUnit(@RequestBody Map map){
        ResultData insert = super.insert(map);
        return insert;
    }


    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 修改单位信息
     **/
    @PostMapping("/updateUnit")
    public ResultData updateUnit(@RequestBody MappingUnit mappingUnit){
        Boolean aBoolean = mappingUnitService.updateUnit(mappingUnit);
        if(aBoolean){
            return super.updateSuccess("修改单位信息");
        }else{
            return super.updateFailed();
        }
    }

}
