package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 18:49
 */
@RestController
public class NewsController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectNews")
    public ResultData selectNews(@RequestParam("title") String title,@RequestParam("pageNumber") Integer pageNumber,
                                 @RequestParam("pageSize") Integer pageSize){
        ResultData resultData = iProjectService.selectNews(title, pageNumber, pageSize);
        return resultData;
    }

    /**
     * @Description: 添加一条新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:21
     **/
    @PostMapping("/insertNews")
    public ResultData insertNews(@RequestBody Map map){
        ResultData resultData = iProjectService.insertNews(map);
        return resultData;
    }

    /**
     * @Description: 修改新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:21
     **/
    @PostMapping("/updateNews")
    public ResultData updateNews(@RequestBody Map map){
        ResultData resultData = iProjectService.updateNews(map);
        return resultData;
    }

    /**
     * @Description: 批量删除新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:21
     **/
    @PostMapping("/deleteNews")
    public ResultData deleteNews(@RequestParam("ids") String ids){
        ResultData resultData = iProjectService.deleteNews(ids);
        return resultData;
    }

    /**
     * @Description: 删除一条新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:20
     **/
    @PostMapping("/deleteOneNews")
    public ResultData deleteOneNews(@RequestBody Map map){
        ResultData resultData = iProjectService.deleteOneNews(map);
        return resultData;
    }
}
