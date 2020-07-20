package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.EquipmentMapper;
import com.qwz.mapper.ResourceMapper;
import com.qwz.model.Equipment;
import com.qwz.model.Resource;
import com.qwz.utils.IDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ResourceMapper resourceMapper;

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

    /**
     * @Description: 添加仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/20 19:47
     **/
    public Boolean insertEquipment(Equipment equipment,String path,Long userid){
        equipment.setId(Long.valueOf(IDUtils.getNum18()));
        equipment.setUserId(userid);
        equipment.setCreateTime(new Date());
        if (equipment != null && !"".equals(equipment)){
            int insert = equipmentMapper.insert(equipment);
            if (insert > 0){
                Resource resourcer = new Resource();
                resourcer.setId(Long.valueOf(IDUtils.getNum18()));
                resourcer.setPath(path);
                resourcer.setRefBizId(equipment.getId());
                resourcer.setCreateTime(new Date());
                resourcer.setExtName(path.substring(path.indexOf("."),path.length()));
                int insert1 = resourceMapper.insert(resourcer);
                if (insert1 > 0){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @Description: 修改仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/20 19:55
     **/
    public Boolean updateEquipment(Equipment equipment,String path){
        equipment.setModifyTime(new Date());
        if (equipment != null && !"".equals(equipment)){
            int update = equipmentMapper.updateByPrimaryKey(equipment);
            if (update > 0){
                Resource resourcer = new Resource();
                resourcer.getId();
                resourcer.setModifyTime(new Date());
                resourcer.setRefBizId(equipment.getId());
                resourcer.setExtName(path.substring(path.indexOf("."),path.length()));
                int update1 = resourceMapper.updateByPrimaryKey(resourcer);
                if (update1 > 0){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @Description: 删除仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/20 19:58
     **/
    public Integer deleteEquipment(Long id){
        int i = equipmentMapper.deleteByPrimaryKey(id);
        if (i > 0){
            return i;
        }else {
            return -1;
        }
    }
}
