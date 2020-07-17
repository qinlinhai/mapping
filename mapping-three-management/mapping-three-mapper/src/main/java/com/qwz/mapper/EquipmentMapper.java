package com.qwz.mapper;

import com.qwz.model.Equipment;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EquipmentMapper extends Mapper<Equipment> {

    /**
     * @Description: 根据userid查询仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/17 15:55
     **/
    List<Equipment> selectEquipment(@Param("userid") Integer userid);

    /**
     * @Description: 根据id查询仪器设备基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:30
     **/
    List<Equipment> selectIdEquipment(@Param("id") Long id);
}