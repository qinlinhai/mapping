package com.qwz.service;

import com.qwz.base.ResultData;
import com.qwz.model.CheckPerson;
import com.qwz.model.LoginLog;
import com.qwz.model.MappingProject;
import com.qwz.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 15:12
 */
@FeignClient(value = "")
public interface IProjectService {

    /**
     * @Description: 执行登录操作
     * @Author: Bing
     * @Date: 2020/7/15 15:14
     **/
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     * @Description: 新增日志
     * @Author: Bing
     * @Date: 2020/7/15 15:18
     **/
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);

    /**
     * @Description: 查询公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:17
     **/
    @PostMapping("/selectNews")
    ResultData selectNews(@RequestParam String title,@RequestParam Integer pageNumber,
                          @RequestParam Integer pageSize);

    /**
     * @Description: 添加公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:17
     **/
    @PostMapping("/insertNews")
    ResultData insertNews(@RequestParam Map map);

    /**
     * @Description: 修改公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:17
     **/
    @PostMapping("/updateNews")
    ResultData updateNews(@RequestBody Map map);

    /**
     * @Description: 批量删除公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:22
     **/
    @PostMapping("/deleteNews")
    ResultData deleteNews(@RequestParam String ids);

    /**
     * @Description: 删除一条公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:16
     **/
    @PostMapping("/deleteOneNews")
    ResultData deleteOneNews(@RequestBody Map map);

    /**
     * @Description: 项目管理  查询登录用户管理的项目
     * @Author: Bing
     * @Date: 2020/7/16 21:49
     **/
    @PostMapping("/selectAdm")
    ResultData selectAdm(@RequestParam String projectType,@RequestParam Integer userid,
                                @RequestParam Integer pageNumber, @RequestParam Integer pageSize);

    /**
     * @Description: 项目管理，添加项目
     * @Author: Bing
     * @Date: 2020/7/16 22:06
     **/
    @PostMapping("/insertAdm")
    ResultData insertAdm(@RequestBody MappingProject mappingProject);

    /**
     * @Description: 项目管理  修改项目
     * @Author: Bing
     * @Date: 2020/7/17 10:44
     **/
    @PostMapping("/updateAdm")
    ResultData updateAdm(@RequestBody MappingProject mappingProject);

    /**
     * @Description:  项目管理  删除项目
     * @Author: Bing
     * @Date: 2020/7/17 10:46
     **/
    @PostMapping("/deleteAdm")
    ResultData deleteAdm(@RequestParam Long id);

    /**
     * @Description: 项目汇交  条件查询
     * @Author: Bing
     * @Date: 2020/7/17 11:04
     **/
    @PostMapping("/selectAdm")
    ResultData selectRem(@RequestParam String projectType,@RequestParam Integer userid,
                                @RequestParam Integer pageNumber, @RequestParam Integer pageSize);

    /**
     * @Description: 项目汇交  修改项目
     * @Author: Bing
     * @Date: 2020/7/17 11:13
     **/
    @PostMapping("/updateRem")
    ResultData updateRem(@RequestBody MappingProject mappingProject);

    /**
     * @Description: 查询抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:19
     **/
    @PostMapping("/selectCheckPerson")
    ResultData selectCheckPerson(@RequestParam HashMap hashMap);

    /**
     * @Description: 添加抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:55
     **/
    @PostMapping("/insertCheckPerson")
    ResultData insertCheckPerson(@RequestBody CheckPerson checkPerson);

    /**
     * @Description: 修改抽查人员信息
     * @Author: Bing
     * @Date: 2020/7/16 16:56
     **/
    @PostMapping("/updateCheckPerson")
    ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson);

    /**
     * @Description: 删除抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:57
     **/
    @PostMapping("/delectOneCheckPerson")
    ResultData delectOneCheckPerson(@RequestParam String id);

    /**
     * @Description: 批量删除抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 17:01
     **/
    @PostMapping("/delectListCheckPerson")
    ResultData delectListCheckPerson(@RequestParam String ids);

    /**
     * @Description: 查询白名单
     * @Author: Bing
     * @Date: 2020/7/16 11:46
     **/
    @PostMapping("/selectWhiteUnit")
    ResultData selectWhiteUnit(@RequestParam HashMap hashMap);

    /**
     * @Description: 查询黑名单
     * @Author: Bing
     * @Date: 2020/7/16 11:46
     **/
    @PostMapping("/selectBlackUnit")
    ResultData selectBlackUnit(@RequestParam HashMap hashMap);

    /**
     * @Description: 根据userid查询仪器设备信息
     * @Author: Bing
     * @Date: 2020/7/17 16:32
     **/
    @PostMapping("/selectEquipment")
    ResultData selectEquipment(@RequestParam Integer userid,@RequestParam Integer pageNumber,
                                      @RequestParam Integer pageSize);

    /**
     * @Description: 根据id查询仪器设备基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:38
     **/
    @PostMapping("/selectIdEquipment")
    ResultData selectIdEquipment(@RequestParam Long id);

    @PostMapping("/selectTec")
    ResultData selectTec(@RequestParam Integer userid,@RequestParam Integer pageNumber,
                                @RequestParam Integer pageSize);

    @PostMapping("/selectOneTec")
    ResultData selectOneTec(@RequestParam Long id);

    @PostMapping("/selectSpecial")
    ResultData selectSpecial(@RequestParam Integer userid,@RequestParam Integer pageNumber,
                                    @RequestParam Integer pageSize);

    @PostMapping("/selectIdSpecial")
    ResultData selectIdSpecial(@RequestParam Long id);
}
