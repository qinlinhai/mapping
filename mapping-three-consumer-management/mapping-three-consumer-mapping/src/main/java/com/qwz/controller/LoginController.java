package com.qwz.controller;

import com.qwz.annotation.LoginAnnotation;
import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.model.User;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 15:10
 */
@RestController
public class LoginController extends BaseController {

    @Autowired
    private IProjectService projectService;

//    /**
//     * @Description: 执行登录操作
//     * @Author: Bing
//     * @Date: 2020/7/15 15:22
//     **/
//    @PostMapping("/doLogin")
//    @LoginAnnotation(opeationType = "登录操作", opeationName = "管理员登录")
//    public ResultData doLogin(@RequestBody User user){
//        return projectService.doLogin(user);
//    }



}
