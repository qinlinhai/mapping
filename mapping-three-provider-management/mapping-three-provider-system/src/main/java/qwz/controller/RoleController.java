package qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.ResultData;
import com.qwz.model.Role;
import com.qwz.model.RoleMenu;
import com.qwz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qwz.base.CommonController;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/17 10:09
 * @describe
 */
@RestController
public class RoleController extends CommonController<Role> {

    @Autowired
    private RoleService roleService;
    @Override
    public BaseService<Role> getBaseService() {
        return roleService;
    }
    /**
     * 分页展示所有的角色
     */
    @GetMapping("/allRole")
    public ResultData allRole(Integer page, Integer limit, @RequestParam Map map){
        PageInfo<Role> rolePageInfo = roleService.allRole(page, limit,map);
        if (rolePageInfo!=null&&rolePageInfo.getSize()>0){
            return super.selectSuccess(rolePageInfo);
        }
        return super.selectFailed();
    }
    /**
     * 查询某个角色所拥有的的权限
     *
     */
    @GetMapping("/allJurisdiction")
    public ResultData allJurisdiction(Integer rolesId){
        List<Map> list = roleService.allJurisdiction(rolesId);
        return super.selectInfo(list);
    }
    /**
     * 修改角色信息
     */
    @PostMapping("/updateRole")
    public ResultData updateRole(RoleMenu roleMenu, Long [] menuId, Role role){
        int i = roleService.updateRole(roleMenu, menuId, role);
        return super.updateInfo(i);

    }
    /**
     * 添加角色
     */
    @PostMapping("/addRole")
    public ResultData addRole(RoleMenu roleMenu, Long [] menuId, Role role){
        int i = roleService.addRole(roleMenu, menuId, role);
        return super.addInfo(i);

    }
    /**
     * 删除角色
     */
    @PostMapping("/deleteRole")
    public ResultData deleteRole(List<Integer> ids){
        int i = roleService.deleteRole(ids);
        return super.deleteInfo(i);
    }


}
