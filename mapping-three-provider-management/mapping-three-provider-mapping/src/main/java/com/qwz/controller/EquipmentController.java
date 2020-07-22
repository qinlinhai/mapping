package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Equipment;
import com.qwz.service.EquipmentService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:30
 */
@RestController
public class EquipmentController extends CommonController<Equipment> {

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

//    /**
//     * @Description: 添加仪器设备信息
//     * @Author: Bing
//     * @Date: 2020/7/20 20:00
//     **/
//    @PostMapping("/insertEquipment")
//    public ResultData insertEquipment(/*@RequestBody*/ Equipment equipment,@RequestParam String path,
//                                      @RequestParam Long userid){
//        Boolean aBoolean = equipmentService.insertEquipment(equipment, path, userid);
//        if (aBoolean){
//            return super.addSuccess(aBoolean);
//        }else {
//            return super.addFailed();
//        }
//    }

//    /**
//     * @Description: 修改仪器设备信息
//     * @Author: Bing
//     * @Date: 2020/7/20 20:02
//     **/
//    @PostMapping("/updateEquipment")
//    public ResultData updateEquipment(/*@RequestBody*/ Equipment equipment,@RequestParam String path){
//        Boolean aBoolean = equipmentService.updateEquipment(equipment, path);
//        if (aBoolean){
//            return super.updateSuccess(aBoolean);
//        }else {
//            return super.updateFailed();
//        }
//    }

    /**
     * @Description: 删除仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/20 20:04
     **/
    @PostMapping("/deleteEquipment")
    public ResultData deleteEquipment(@RequestParam Long id){
        Integer integer = equipmentService.deleteEquipment(id);
        if (integer > 0){
            return super.deleteSuccess(integer);
        }else {
            return super.deleteFailed();
        }
    }
}
