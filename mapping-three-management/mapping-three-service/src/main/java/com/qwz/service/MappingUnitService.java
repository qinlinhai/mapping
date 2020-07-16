package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.MappingUnitMapper;
import com.qwz.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

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

    public List<Map> selectUnitByType(String unitArea){
        List<Map> maps = mappingUnitMapper.selectUnitByType(unitArea);
        if(maps!=null && maps.size()>0){
            return maps;
        }else{
            return null;
        }
    }
}
