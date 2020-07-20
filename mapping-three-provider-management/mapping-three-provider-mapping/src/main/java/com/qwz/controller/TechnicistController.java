package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Technicist;
import com.qwz.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:03
 */
@RestController
public class TechnicistController extends CommonController<Technicist> {

    @Autowired
    private TechnicistService technicistService;

    public BaseService<Technicist> getBaseService() {
        return technicistService;
    }

    /**
     * @Description: 根据userid查询技术人员信息
     * @Author: Bing
     * @Date: 2020/7/17 16:07
     **/
    @PostMapping("/selectTec")
    public ResultData selectTec(@RequestParam Integer userid,@RequestParam Integer pageNumber,
                                @RequestParam Integer pageSize){
        PageInfo pageInfo = technicistService.selectTec(userid, pageNumber, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 根据id查询技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/17 17:12
     **/
    @PostMapping("/selectOneTec")
    public ResultData selectOneTec(@RequestParam Long id){
        List<Technicist> technicists = technicistService.selectOneTec(id);
        if (technicists != null && !"".equals(technicists)){
            return super.selectSuccess(technicists);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 添加技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/20 20:41
     **/
    @PostMapping("/insertTec")
    public ResultData insertTec(@RequestBody Technicist technicist,@RequestParam Long userid){
        Integer integer = technicistService.insertTec(technicist, userid);
        if (integer > 0){
            return super.addSuccess(integer);
        }else {
            return super.addFailed();
        }
    }

    /**
     * @Description: 修改技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/20 20:43
     **/
    @PostMapping("/updateTec")
    public ResultData updateTec(@RequestBody Technicist technicist){
        Integer integer = technicistService.updateTec(technicist);
        if (integer > 0){
            return super.updateSuccess(integer);
        }else {
            return super.updateFailed();
        }
    }

    /**
     * @Description: 删除技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/20 20:44
     **/
    @PostMapping("/deleteTec")
    public ResultData deleteTec(@RequestParam Long id){
        Integer integer = technicistService.deleteTec(id);
        if (integer > 0){
            return super.deleteSuccess(integer);
        }else {
            return super.deleteFailed();
        }
    }
}
