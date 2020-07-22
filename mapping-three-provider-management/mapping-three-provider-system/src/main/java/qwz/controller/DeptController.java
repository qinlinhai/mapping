package qwz.controller;

import com.qwz.base.BaseService;
import com.qwz.base.ResultData;
import com.qwz.model.Dept;
import com.qwz.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import qwz.base.CommonController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/15 17:44
 * @describe
 */
@RestController
public class DeptController extends CommonController<Dept> {
   @Autowired
    private DeptService deptService;
    @Override
    public BaseService<Dept> getBaseService() {
        return deptService;
    }
    /**
     * 获取所有部门信息
     */

    @GetMapping("/deptList")
    public ResultData selectDeptByNameOrCreateTime(@RequestBody Map map){
        List list = deptService.selectDeptByNameOrCreateTime(map);
        return super.selectInfo(list);
    }

    /**
     * 新增部门信息
     */
    @PostMapping("/addDept")
    public ResultData addDept(@RequestBody Dept dept) {
        Integer insert = deptService.insert(dept);
        return super.addInfo(insert);
    }

    /**
     * 修改部门信息
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept){
        dept.setModifyTime(new Date());
        Integer update = deptService.update(dept);
        return super.updateInfo(update);
    }
    /**
     * 删除部门信息
     */
    @PostMapping("/deleteDept")
    public ResultData deleteDept(@RequestBody List<Integer> ids){
        Integer integer = deptService.deleteByIds(ids);
        return super.deleteInfo(integer);
    }
}
