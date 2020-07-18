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
        PageInfo<MappingUnit> mappingUnitPageInfo = new PageInfo<MappingUnit>(mappingUnits);
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
        Map<Object, Object> project = new HashMap<Object, Object>();
        project.put("projectCount",integer);
        Map<Object, Object> special = new HashMap<Object, Object>();
        special.put("specialCount",integer1);
        maps.add(project);
        maps.add(special);
        return maps;
    }

    public List<Map> selectUnitPersonEquipment(String unitArea){
        List<Map> list1 = mappingUnitMapper.selectUnitByType(unitArea);
        List<Map> list2 = mappingUnitMapper.selectTechPersonByType(unitArea);
        List<Map> list3 = mappingUnitMapper.selectEquipmentByType(unitArea);
        List<Map> result=new ArrayList<Map>();
        Map<Object, Object> map1 = new HashMap<Object, Object>();
        Map<Object, Object> map2 = new HashMap<Object, Object>();
        Map<Object, Object> map3 = new HashMap<Object, Object>();
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


    /**
     * @Description: 查询白名单
     * @Author: Bing
     * @Date: 2020/7/16 11:42
     **/
    public PageInfo selectWhiteUnit(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNumber")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo pageInfo = new PageInfo(mappingUnitMapper.selectwhiteUnit());
        if (null != pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }

    /**
     * @Description: 查询黑名单
     * @Author: Bing
     * @Date: 2020/7/16 11:42
     **/
    public PageInfo selectBlackUnit(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNumber")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo pageInfo = new PageInfo(mappingUnitMapper.selectBlackUnit());
        if (null != pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页模糊查询所有单位
     **/

    public PageInfo selectAllUnitVague(Integer currentPage,Integer pageSize,String unitName) throws Exception {
        if(currentPage == null && "".equals(currentPage)){
            throw new Exception("pageNumber不能为空");
        }
        if (pageSize == null && "".equals(pageSize)){
            throw new Exception("pageSize不能为空");
        }
        PageHelper.startPage(currentPage,pageSize);
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectAllUnitVague(unitName);
        PageInfo<MappingUnit> mappingUnitPageInfo = new PageInfo<MappingUnit>(mappingUnits);
        if(mappingUnitPageInfo!=null){
            return mappingUnitPageInfo;
        }else{
            return null;
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页模糊查询待修改单位列表
     **/
    public PageInfo selectUnitNoUpdateAudit(Integer currentPage,Integer pageSize,String unitName) throws Exception {
        if(currentPage == null && "".equals(currentPage)){
            throw new Exception("pageNumber不能为空");
        }
        if (pageSize == null && "".equals(pageSize)){
            throw new Exception("pageSize不能为空");
        }
        PageHelper.startPage(currentPage,pageSize);
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectUnitNoUpdateAudit(unitName);
        PageInfo<MappingUnit> mappingUnitPageInfo = new PageInfo<MappingUnit>(mappingUnits);
        if(mappingUnitPageInfo!=null && !"".equals(mappingUnitPageInfo)){
                return mappingUnitPageInfo;
        }else{
            return null;
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页 模糊查询待审核单位列表
     *
     **/

    public PageInfo selectUnitNoRegister(Integer currentPage,Integer pageSize,String unitName) throws Exception {
        if(currentPage == null && "".equals(currentPage)){
            throw new Exception("pageNumber不能为空");
        }
        if (pageSize == null && "".equals(pageSize)){
            throw new Exception("pageSize不能为空");
        }
        List<MappingUnit> mappingUnits = mappingUnitMapper.selectUnitNoRegister(unitName);
        PageInfo<MappingUnit> mappingUnitPageInfo = new PageInfo<MappingUnit>(mappingUnits);
        if(mappingUnitPageInfo != null && !"".equals(mappingUnitPageInfo)){
            return mappingUnitPageInfo;
        }else{
            return null;
        }
    }


    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据userId查询单位基本信息
     **/

    public MappingUnit selectUnitByUserId(MappingUnit mappingUnit){
        if(mappingUnit!= null && !"".equals(mappingUnit)){
            MappingUnit mappingUnit1 = super.selectOne(mappingUnit);
            if(mappingUnit1!=null && !"".equals(mappingUnit1)){
                return mappingUnit1;
            }else{
                return null;
            }
        }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 查询关于此单位的附件
     **/
    public List<Map> selectResourceByUnitId(Integer userId){
        if(userId!=null){
            List<Map> maps = mappingUnitMapper.selectResourceByUserId(userId);
            if(maps!=null && maps.size()>0){
                return maps;
            }else{
                return null;
            }
        }
        return null;
    }
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 修改单位的分值
     **/
    public Boolean updateUnitScore(Integer score,Long unitId){
        if(score!=null && unitId!=null){
            int i = mappingUnitMapper.updateUnitScore(unitId, score);
            if(i>0){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 修改单位状态
     **/
    public Boolean updateUnitStatus(Long unitId,Integer auditStatus){
       if(unitId!=null&& auditStatus!=null){
           int i = mappingUnitMapper.updateUnitAuditstatus(auditStatus, unitId);
           if(i>0){
               return true;
           }else{
               return false;
           }
       }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 分页双随机抽查单位
     **/

    public PageInfo selectUnitRandom(Integer currentPage,Integer pageSize,double random,String ownedDistrict){
        if(currentPage!=null && pageSize!=null){
            PageHelper.startPage(currentPage,pageSize);
            int i = mappingUnitMapper.selectUnitCount();
            int randomCount= (int) (random*i);
            Integer randomCount1=randomCount;
            if(randomCount1!=null){
                List<MappingUnit> mappingUnits = mappingUnitMapper.selectUnitRandom(randomCount1,ownedDistrict);
                if(mappingUnits!=null){
                    PageInfo<MappingUnit> mappingUnitPageInfo = new PageInfo<MappingUnit>(mappingUnits);
                    if(mappingUnitPageInfo!=null){
                        return mappingUnitPageInfo;
                    }else{
                        return null;
                    }
                }
            }

        }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 根据单位的 name level area查询单位
     **/

        public List<MappingUnit> selectUnitBynameAndLevelAndArea(String unitName,String unitLevel,String unitArea){
                List<MappingUnit> mappingUnits = mappingUnitMapper.selectUnitBynameAndLevelAndArea(unitName, unitArea, unitLevel);

                if(mappingUnits!=null&& mappingUnits.size()>0){
                    return mappingUnits;
                }else{
                    return null;
                }
        }


}
