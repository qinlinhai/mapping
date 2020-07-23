package com.qwz.controller;

import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.model.LoginLog;
import com.qwz.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/23 9:36
 */
@RestController
public class LoginLogController extends CommonController {

    @Autowired
    private LoginLogService loginLogService;

    public BaseService getBaseService() {
        return loginLogService;
    }

    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody LoginLog loginLog) {
        return getBaseService().insert(loginLog);
    }
}
