package com.qwz.mapper;

import com.qwz.model.Dept;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface DeptMapper extends Mapper<Dept> {
    /**
     *  条件查询部门列表，如果有条件就根据条件查询，如果没有就展示所有部门列表
     */
    List<Dept> selectDeptByNameOrCreateTime(Map map);
}