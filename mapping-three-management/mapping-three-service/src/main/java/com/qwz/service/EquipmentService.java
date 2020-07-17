package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.EquipmentMapper;
import com.qwz.model.Equipment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:18
 */
@Service
@Slf4j
public class EquipmentService extends BaseService<Equipment> {

    @Autowired
    private EquipmentMapper equipmentMapper;

    /**
     * @Description: 根据userid查询仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/17 16:20
     **/
    public PageInfo selectEquipment(Integer userid,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<Equipment> equipment = equipmentMapper.selectEquipment(userid);
        PageInfo pageInfo = new PageInfo(equipment);
        return pageInfo;
    }

    /**
     * @Description: 根据id查询仪器设备基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:34
     **/
    public List<Equipment> selectIdEquipment(Long id){
        List<Equipment> equipment = equipmentMapper.selectIdEquipment(id);
        return equipment;
    }
}
