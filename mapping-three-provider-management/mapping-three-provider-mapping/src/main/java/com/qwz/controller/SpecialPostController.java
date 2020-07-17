package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.SpecialPost;
import com.qwz.service.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:27
 */
@RestController
public class SpecialPostController extends CommonController {

    @Autowired
    private SpecialPostService specialPostService;

    public BaseService getBaseService() {
        return specialPostService;
    }

    /**
     * @Description: 根据userid查询特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/17 16:29
     **/
    @PostMapping("/selectSpecial")
    public ResultData selectSpecial(@RequestParam Integer userid,@RequestParam Integer pageNumber,
                                    @RequestParam Integer pageSize){
        PageInfo pageInfo = specialPostService.selectSpecial(userid, pageNumber, pageSize);
        if (pageInfo != null && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 根据id查询特殊人员基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:36
     **/
    @PostMapping("/selectIdSpecial")
    public ResultData selectIdSpecial(@RequestParam Long id){
        List<SpecialPost> specialPosts = specialPostService.selectIdSpecial(id);
        if (specialPosts != null && !"".equals(specialPosts)){
            return super.selectSuccess(specialPosts);
        }else {
            return super.selectFailed();
        }

    }
}
