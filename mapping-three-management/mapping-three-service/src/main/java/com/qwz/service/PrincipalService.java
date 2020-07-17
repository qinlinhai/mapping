package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.mapper.PrincipalMapper;
import com.qwz.model.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据id查询负责人信息
     **/
    public Principal selectOneByUserId(Principal principal){
        if(principal!=null && !"".equals(principal)){
            Principal principal1 = super.selectOne(principal);
            if(principal1!=null && !"".equals(principal1)){
                return principal;
            }else{
                return null;
            }
        }
        return null;
    }
}
