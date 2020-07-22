package qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.ResultData;
import com.qwz.model.User;
import com.qwz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qwz.base.CommonController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/16 22:12
 * @describe
 */
@RestController
public class UserController extends CommonController<User> {
    @Autowired
    private UserService userService;
    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }
    /**
     * 分页查询用户列表
     */
    @GetMapping("/allUser")
    public ResultData allUser(@RequestParam Map map, Integer page, Integer limit){
        PageInfo<Map> userPageInfo = userService.allUser(page, limit,map);
        if (userPageInfo!=null&&userPageInfo.getSize()>0){
            return super.selectSuccess(userPageInfo);
        }
        return selectFailed();

    }
    /**
     * 新增用户
     */
    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody User user){
        user.setCreateTime(new Date());
        Integer integer = userService.insertSelective(user);
        return super.addInfo(integer);
    }

    /**
     * 修改用户
     */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody User user){
        user.setModifyTime(new Date());
        Integer update = userService.update(user);
        return super.updateInfo(update);
    }

    /**
     * 批量删除用户
     */
    @PostMapping("/deleteUser")
    public ResultData deleteUser(@RequestBody List<Integer> ids){
        Integer integer = userService.deleteByIds(ids);
        return super.deleteInfo(integer);
    }


}
