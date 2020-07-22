package com.qwz.mapper;

import com.qwz.model.RoleMenu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMenuMapper extends Mapper<RoleMenu> {
    /**
     * 根据menuId查询所拥有的权限
     *
     * */
    List<Map> allJurisdiction(Integer rolesId);

    /**
     * 添加权限权限
     */
    int addJurisdiction(RoleMenu roleMenu);

    /**
     * 删除某个roleId的所有权限
     */
    int deleteAllJurisdiction(Long roleId);

}