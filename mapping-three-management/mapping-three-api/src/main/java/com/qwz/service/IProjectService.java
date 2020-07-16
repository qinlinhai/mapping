package com.qwz.service;

import com.qwz.base.ResultData;
import com.qwz.model.LoginLog;
import com.qwz.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
