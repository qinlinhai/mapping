package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.RoleMapper;
import com.qwz.mapper.RoleMenuMapper;
import com.qwz.model.Role;
import com.qwz.model.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/17 10:02
 * @describe
 */
@Service
public class RoleService extends BaseService<Role> {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    /**
     * 分页展示角色
     */
    public PageInfo<Role> allRole(Integer page, Integer limit, Map map){
        PageHelper.offsetPage((page-1)*limit,limit);
        List<Role> roles = roleMapper.allRole(map);
        PageInfo pageInfo=new PageInfo(roles);
        return pageInfo;
    }
    /**
     * 根据角色id查看拥有的所有权限
     */
    public List<Map> allJurisdiction(Integer rolesId){
        List<Map> list = roleMenuMapper.allJurisdiction(rolesId);
        return list;
    }
    /**
     * 修改角色
     */
    @Transactional(rollbackFor = Exception.class)
    public int updateRole(RoleMenu roleMenu, Long [] menuId, Role role){
        //修改角色基本信息
        role.setModifyTime(new Date());
        int basic = roleMapper.updateByPrimaryKey(role);
        Long roleId = roleMenu.getRoleId();
        //根据roleId删除t_role_menu表中的所有权限
        int result=roleMenuMapper.deleteAllJurisdiction(roleId);
        int results=basic+result;
        //把更改后的权限加入t_role_menu表
        if (result>0&&menuId!=null&&menuId.length>0){
            for (int i=0;i<menuId.length;i++){
                roleMenu.setMenuId(menuId[i]);
            int i1 = roleMenuMapper.addJurisdiction(roleMenu);
            if(i1==0){
                throw new RuntimeException("");
            }
            }
        }

        return results;
    }
    /**
     * 添加角色
     */
    @Transactional(rollbackFor = Exception.class)
    public int addRole(RoleMenu roleMenu, Long [] menuId, Role role){
        //添加基本信息
        role.setCreateTime(new Date());
        int basic = roleMapper.insertSelective(role);
        List<Long> longs = roleMapper.nextRoleId();
        roleMenu.setRoleId(longs.get(0));
        //添加权限
        if (basic>0&&menuId!=null&&menuId.length>0){
            for (int i=0;i<=menuId.length;i++){
                roleMenu.setMenuId(menuId[i]);
                int i1 = roleMenuMapper.addJurisdiction(roleMenu);
                if(i1==0){
                    throw new RuntimeException("");
                }
            }
        }
        return basic;
    }
    /**
     * 删除角色
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteRole(List<Integer> ids){
        //删除基本信息
        Integer integer = super.deleteByIds(ids);
        if (integer>0&&ids!=null&&ids.size()>0){
            //删除权限
            for(int i=0;i<ids.size();i++){
                Integer id=ids.get(0);
                int i1 = roleMenuMapper.deleteByPrimaryKey(id);
                if(i1==0){
                    throw new RuntimeException("");
                }
            }
        }
        return integer;
    }

}
