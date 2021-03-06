package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 19:49
 */
@RestController
public class TechnicistController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectTec")
    public ResultData selectTec(@RequestParam("userid") Integer userid, @RequestParam("pageNumber") Integer pageNumber,
                                @RequestParam("pageSize") Integer pageSize){
        ResultData resultData = iProjectService.selectTec(userid, pageNumber, pageSize);
        return resultData;
    }

    @PostMapping("/selectOneTec")
    public ResultData selectOneTec(@RequestParam("id") Long id){
        ResultData resultData = iProjectService.selectOneTec(id);
        return resultData;
    }
}
