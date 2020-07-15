package com.qwz.mapper;

import com.qwz.model.MappingProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
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
     * 根据id查询次项目的详细信息
     * @param id
     * @return
     */
    @Select("select * from t_mapping_project where user_id=25 and audit_status=0 and id=#{id}")
    MappingProject selectSuccessRegisterById(Integer id);
    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功汇交的项目信息
     **/
    List<MappingProject> selectSuccessRemittance(Integer userId,String search);


}