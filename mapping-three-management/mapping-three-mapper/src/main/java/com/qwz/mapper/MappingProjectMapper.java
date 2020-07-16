package com.qwz.mapper;

import com.qwz.model.MappingProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface MappingProjectMapper extends Mapper<MappingProject> {

    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功登记的项目信息
     **/
    List<MappingProject> selectSuccessRegister(Integer userId,String search);

    /**
     * 根据项目id查询次项目的详细信息
     * @param projectId
     * @return
     */
    @Select("select * from t_mapping_project where user_id=25 and audit_status=0 and id=#{projectId}")
    MappingProject selectSuccessRegisterById(Long projectId);
    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功汇交的项目信息
     **/
    List<MappingProject> selectSuccessRemittance(Integer userId,String search);
    /**
     * @author  qlh
     * @date   2020/7/15
     * @desc
     * 通过项目id查询项目以及附件
     **/
    @Select("select mp.*,r.name,r.path,r.ext_name from t_mapping_project mp " +
            "left join t_resource r on mp.id=r.ref_biz_id where mp.id=#{projectId}")
    List<Map> selectProjectandResource(Long projectId);


}