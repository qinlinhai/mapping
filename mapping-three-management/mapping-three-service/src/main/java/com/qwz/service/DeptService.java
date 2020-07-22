package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.mapper.DeptMapper;
import com.qwz.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/15 16:44
 * @describe
 */
@Service
public class DeptService extends BaseService<Dept> {
    @Autowired
    private DeptMapper deptMapper;
    /**
     * 查询部门列表
     */
        public List selectDeptByNameOrCreateTime(Map map){
            return deptMapper.selectDeptByNameOrCreateTime(map);
        }



}
