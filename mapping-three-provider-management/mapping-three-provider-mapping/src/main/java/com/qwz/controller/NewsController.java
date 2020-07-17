package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.News;
import com.qwz.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 17:17
 */
@RestController
public class NewsController extends CommonController<News> {

    @Autowired
    private NewsService newsService;

    public BaseService<News> getBaseService() {
        return newsService;
    }

    /**
     * @Description: 查询公告新闻
     *     @RequestParam 一般作用于 Map  和基本类型
     *     @RequestBody  一般作用于实体类对象
     * @Author: Bing
     * @Date: 2020/7/16 16:18
     **/
    @PostMapping("/selectNews")
    public ResultData selectNews(@RequestParam String title,@RequestParam Integer pageNumber,
                                 @RequestParam Integer pageSize){
        PageInfo pageInfo = newsService.selectNewss(title, pageNumber, pageSize);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 添加公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:22
     **/
    @PostMapping("/insertNews")
    public ResultData insert(@RequestBody News news){
        Integer integer = newsService.insertNews(news);
        if (integer > 0){
            return super.addSuccess(integer);
        }else {
            return super.addFailed();
        }
    }

    /**
     * @Description: 修改公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:22
     **/
    @PostMapping("/updateNews")
    public ResultData updateNews(@RequestBody News news){
        Integer updateNews = newsService.updateNews(news);
        if (updateNews > 0){
            return super.updateSuccess(updateNews);
        }else {
            return super.updateFailed();
        }
    }

    /**
     * @Description: 批量删除公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:22
     **/
    @PostMapping("/deleteNews")
    public ResultData deleteNews(@RequestParam List<Integer> ids){
        Integer integer = newsService.delectListNews(ids);
        if (integer > 0){
            return  super.deleteSuccess(integer);
        }else {
            return super.deleteFailed();
        }
    }

    /**
     * @Description: 删除一条数据
     * @Author: Bing
     * @Date: 2020/7/16 11:16
     **/
    @PostMapping("/deleteOneNews")
    public ResultData deleteOneNews(@RequestParam String id){
        Integer delectNews = newsService.delectNews(id);
        if (delectNews > 0){
            return super.deleteSuccess(delectNews);
        }else {
            return super.deleteFailed();
        }
    }

}
