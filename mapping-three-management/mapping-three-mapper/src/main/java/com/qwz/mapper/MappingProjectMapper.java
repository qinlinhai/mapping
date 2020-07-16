package com.qwz.mapper;

import com.qwz.model.MappingProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
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
    List<MappingProject> selectSuccessRegister(String search);

    /**
     * 根据项目id查询次项目的详细信息
     * @param projectId
     * @return
     */

    MappingProject selectSuccessRegisterById(Long projectId);
    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功汇交的项目信息
     **/
    List<MappingProject> selectSuccessRemittance(String search);
    /**
     * @author  qlh
     * @date   2020/7/15
     * @desc
     * 通过项目id查询项目以及附件
     **/
    List<Map> selectProjectandResource(Long projectId);


    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     *  查询未审核的项目
     **/
    List<MappingProject> selectNoAudit(@Param("projectName") String projectName);
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询为汇交的项目
     **/
    List<MappingProject> selectNoRemittance(@Param("projectName") String projectName);


    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询 已经完成的项目
     **/
    @Select("select count(project_type) count,project_type type from t_mapping_project where status=3 GROUP BY project_type")
    List<Map> selectSuccess();


    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询未完成的项目
     **/
    @Select("select count(project_type) count,project_type type from t_mapping_project where status=2 GROUP BY project_type")
    List<Map> selectFailed();

}