package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 19:45
 */
@RestController
public class EquipmentController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectEquipment")
    public ResultData selectEquipment(@RequestParam("userid") Integer userid,@RequestParam("pageNumber") Integer pageNumber,
                                      @RequestParam("pageSize") Integer pageSize){
        ResultData resultData = iProjectService.selectEquipment(userid, pageNumber, pageSize);
        return resultData;
    }

    @PostMapping("/selectIdEquipment")
    public ResultData selectIdEquipment(@RequestParam("id") Long id){
        ResultData resultData = iProjectService.selectIdEquipment(id);
        return resultData;
    }
}
