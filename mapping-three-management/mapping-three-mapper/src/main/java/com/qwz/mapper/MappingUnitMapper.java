package com.qwz.mapper;

import com.qwz.model.MappingUnit;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface MappingUnitMapper extends Mapper<MappingUnit> {

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 根据资质等级分组查询单位
     **/
    @Select("select count(qualification_level) levelCount,qualification_level level from t_mapping_unit GROUP BY qualification_level")
    public List<Map> selectQualification();
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询 技术人员
     * 特殊人员
     * 项目数量
     **/
    @Select("select count(major_type),major_type from  t_technicist where user_id=#{userId} GROUP BY major_type")
    List<Map> selectUnitTech(@Param("userId") Integer userId);
    @Select("select count(*) from t_special_post where user_id=#{userId}")
    Integer selectSpecialCount(@Param("userId") Integer userId);
    @Select("select count(*) from t_mapping_project where user_id=#{userId}")
    Integer selectProjectCount(@Param("userId") Integer userId);



    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询 资质等级查询单位数量
     **/

    List<Map> selectUnitByType(String unitArea);
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询 根据资质等级查询技术人员数量
     **/
    List<Map> selectTechPersonByType(String unitArea);

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询 根据资质等级查询设备数量
     **/
    List<Map> selectEquipmentByType(String unitArea);

    /**
     * @Description: 查询白名单
     * @Author: Bing
     * @Date: 2020/7/16 11:35
     **/
    List<MappingUnit> selectwhiteUnit();

    /**
     * @Description: 查询黑名单
     * @Author: Bing
     * @Date: 2020/7/16 11:38
     **/
    List<MappingUnit> selectBlackUnit();

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页 模糊查询所有单位
     **/

    List<MappingUnit> selectAllUnitVague(String unitName);


    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页模糊查询 未注册通过的单位
     **/
    List<MappingUnit> selectUnitNoRegister(String unitName);
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 分页模糊查询 待修改审核
     *
     **/
    List<MappingUnit> selectUnitNoUpdateAudit(String unitName);
}