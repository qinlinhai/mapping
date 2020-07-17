package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.model.User;
import com.qwz.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 15:37
 */
@Service
public class LoginService extends BaseService<User> {

    /**
     * @Description: 执行登录操作
     * @Author: Bing
     * @Date: 2020/7/15 15:42
     **/
    public TokenVo doLogin(User user){
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();
        //判断User是否为null
        if (null != user){
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
            //判断user2是否为null
            if (null == user2){
                tokenVo.setIfSuccess(false);
                tokenVo.setType(1);
                return tokenVo;
            }else {
                //用户名正确，查询密码
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
                //判断user3是否为null
                if (null == user3){
                    tokenVo.setIfSuccess(false);
                    tokenVo.setType(2);
                    return tokenVo;
                }else {
                    //登录成功
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
                    user3.setToken(token);
                    Integer update = super.update(user3);
                    if (update > 0){
                        tokenVo.setIfSuccess(true);
                        tokenVo.setToken(token);
                    }else {
                        tokenVo.setIfSuccess(true);
                        tokenVo.setType(4);
                        return tokenVo;
                    }
                }
            }
        }else {
            tokenVo.setIfSuccess(false);
            tokenVo.setType(4);
            return tokenVo;
        }
        return tokenVo;
    }

}
