package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Principal;
import com.qwz.service.PrincipalService;
import com.qwz.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
public class PrincipalController extends CommonController<Principal> {
    @Override
    public BaseService<Principal> getBaseService() {
        return null;
    }
    @Autowired
    private PrincipalService principalService;

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据userId 查询 单位负责人信息
     **/
    @PostMapping("/selectOneByUserId")
    public ResultData selectOneByUserId(@RequestParam("userId") Integer userId,@RequestParam("currentPage") Integer currentPage,
                                        @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = principalService.selectOneByUserId(userId, currentPage, pageSize);
       if(pageInfo!=null){
           return super.selectSuccess("查询负责人列表成功",pageInfo);
       }else{
           return super.selectFailed("查询负责人列表失败");
       }

    }
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据负责人id查询负责人基本信息和附件
     **/
    @GetMapping("/selectPrincipalEnclosure")
    public ResultData selectPrincipalEnclosure(@RequestParam("principalId") Long principalId){
        List<Map> maps = principalService.selectPrincipalEnclosure(principalId);
        if(maps!=null&& maps.size()>0){
            return super.selectSuccess("查询负责人信息附件成功",maps);
        }else{
            return super.selectFailed("查询失败");
        }
    }
    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 新增一个负责人信息
     **/
    @PostMapping("/addPrincipal")
    public ResultData  addPrincipal(@RequestBody Principal principal){
        principal.setId(Long.valueOf(IDUtils.getNum18().toString()));
        Boolean aBoolean = principalService.addPrincipal(principal);
        if(aBoolean){
            return super.addSuccess("新增负责人信息成功");
        }else{
            return super.addFailed("新增负责人信息失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 修改负责人信息
     **/
    @PostMapping("/updatePrincipal")
    public ResultData updatePrincipal(@RequestBody Principal principal){

        Boolean aBoolean = principalService.updatePrincipal(principal);
        if(aBoolean){
            return super.updateSuccess("修改负责人信息成功");
        }else{
            return super.updateFailed("修改负责人信息失败");
        }
    }
    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 删除负责人信息
     **/
    @PostMapping("/deletePrincipal")
    public ResultData deletePrincipal(@RequestBody Principal principal){
        Boolean aBoolean = principalService.deletePrincipal(principal);
        if(aBoolean){
            return super.deleteSuccess("删除负责人成功");
        }else{
            return super.deleteFailed("删除负责人失败");
        }
    }

    @PostMapping("/principalUploadService")
    public ResultData principalUploadService(@RequestParam("manyfile") MultipartFile[] manyfile,@RequestParam("refBizType") String refBizType,@RequestParam("refBizId") Long refBizId,
                                             @RequestParam("memo") String memo){
        Boolean aBoolean = principalService.PrincipalUploadService(manyfile, refBizType,refBizId,memo);
        if(aBoolean){
            return super.addSuccess();
        }else{
            return super.addFailed();
        }
    }

}
