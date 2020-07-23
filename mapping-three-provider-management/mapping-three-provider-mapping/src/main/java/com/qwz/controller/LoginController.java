package com.qwz.controller;

import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.User;
import com.qwz.service.LoginService;
import com.qwz.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.qwz.status.LoginStatus.*;


/**
 * @description:
 * @author: Bing
 * @time: 2020/7/23 8:42
 */
@RestController
public class LoginController extends CommonController {

    @Autowired
    private LoginService loginService;

    public BaseService getBaseService() {
        return loginService;
    }

    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user){
        TokenVo tokenVo = loginService.doLogin(user);
        if (tokenVo.getIfSuccess()){
            return super.loginSuccess(tokenVo.getToken());
        }else if (tokenVo.getType() == 1){
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        }else if (tokenVo.getType() == 2) {
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        }else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }
    }
}
