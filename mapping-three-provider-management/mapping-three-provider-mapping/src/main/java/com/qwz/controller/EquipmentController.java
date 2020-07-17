package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Equipment;
import com.qwz.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:30
 */
@RestController
public class EquipmentController extends CommonController {

    @Autowired
    private EquipmentService equipmentService;

    public BaseService getBaseService() {
        return equipmentService;
    }

    /**
     * @Description: 根据userid查询仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/17 16:32
     **/
    @PostMapping("/selectEquipment")
    public ResultData selectEquipment(@RequestParam Integer userid,@RequestParam Integer pageNumber,
                                      @RequestParam Integer pageSize){
        PageInfo pageInfo = equipmentService.selectEquipment(userid, pageNumber, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 根据id查询仪器设备基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:38
     **/
    @PostMapping("/selectIdEquipment")
    public ResultData selectIdEquipment(@RequestParam Long id){
        List<Equipment> equipment = equipmentService.selectIdEquipment(id);
        if (equipment != null && !"".equals(equipment)){
            return super.selectSuccess(equipment);
        }else {
            return super.selectFailed();
        }
    }
}
