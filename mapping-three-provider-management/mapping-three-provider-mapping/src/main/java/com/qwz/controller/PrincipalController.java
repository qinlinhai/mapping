package com.qwz.controller;

import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Principal;
import com.qwz.service.PrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController extends CommonController<Principal> {
    @Override
    public BaseService<Principal> getBaseService() {
        return null;
    }
    @Autowired
    private PrincipalService principalService;

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据userId 查询 单位负责人信息
     **/
    @PostMapping("/selectOneByUserId")
    public ResultData selectOneByUserId(Principal principal){
        Principal principal1 = principalService.selectOneByUserId(principal);
        if(principal!=null && !"".equals(principal)){
            return super.selectSuccess("查询单位负责人信息成功",principal1);
        }else{
            return super.selectFailed("查询单位负责人信息失败");
        }
    }

}
