package com.qwz.mapper;

import com.qwz.model.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper extends Mapper<Role> {
    /**
     * 模糊查询角色列表
     */
    List<Role> allRole(Map map);

    /**
     * 查询表中下一要添加的roleId
     */
    List<Long> nextRoleId();


}