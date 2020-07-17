package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.Technicist;
import com.qwz.service.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:03
 */
@RestController
public class TechnicistController extends CommonController<Technicist> {

    @Autowired
    private TechnicistService technicistService;

    public BaseService<Technicist> getBaseService() {
        return technicistService;
    }

    /**
     * @Description: 根据userid查询技术人员信息
     * @Author: Bing
     * @Date: 2020/7/17 16:07
     **/
    @PostMapping("/selectTec")
    public ResultData selectTec(@RequestParam Integer userid,@RequestParam Integer pageNo,
                                @RequestParam Integer pageSize){
        PageInfo pageInfo = technicistService.selectTec(userid, pageNo, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }
}
