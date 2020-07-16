package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.MappingUnitMapper;
import com.qwz.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MappingUnitService  extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;

        /**
         * @author  qlh
         * @date   2020/7/16
         * @desc
         * 根据资质等级查询单位数据
         **/
    public List<Map> selectQualification(){
        List<Map> maps = mappingUnitMapper.selectQualification();
        if(maps!=null && maps.size()>0){
            return maps;
        }else{
            return null;
        }
    }
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 分页查询所有的单位信息
     **/
    public PageInfo selectAll(Integer currentPage,Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectAll();
        PageInfo<MappingUnit> mappingUnitPageInfo = new PageInfo<>(mappingUnits);
        if(mappingUnitPageInfo!=null){
            return mappingUnitPageInfo;
        }else{
            return null;
        }
    }


    public List<Map> selectPersonByuserId(Integer userId){
        List<Map> maps = mappingUnitMapper.selectUnitTech(userId);
        Integer integer = mappingUnitMapper.selectProjectCount(userId);
        Integer integer1 = mappingUnitMapper.selectSpecialCount(userId);
        Map<Object, Object> project = new HashMap<>();
        project.put("projectCount",integer);
        Map<Object, Object> special = new HashMap<>();
        special.put("specialCount",integer1);
        maps.add(project);
        maps.add(special);
        return maps;
    }

    public List<Map> selectUnitPersonEquipment(String unitArea){
        List<Map> list1 = mappingUnitMapper.selectUnitByType(unitArea);
        List<Map> list2 = mappingUnitMapper.selectTechPersonByType(unitArea);
        List<Map> list3 = mappingUnitMapper.selectEquipmentByType(unitArea);
        List<Map> result=new ArrayList<>();
        Map<Object, Object> map1 = new HashMap<>();
        Map<Object, Object> map2 = new HashMap<>();
        Map<Object, Object> map3 = new HashMap<>();
        if(list1!=null && list1.size()>0){
            map1.put("unit",list1);
        }
        if(list2!=null && list2.size()>0){
            map2.put("techPerson",list2);
        }
        if(list3!=null && list3.size()>0){
            map3.put("Equipment",list3);
        }
        result.add(map1);
        result.add(map2);
        result.add(map3);
        return result;


    }
}
