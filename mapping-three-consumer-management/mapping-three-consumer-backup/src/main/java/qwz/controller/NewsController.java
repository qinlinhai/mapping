package qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.service.NewsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 18:49
 */
@RestController
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/selectNews")
    @ApiOperation(value = "分页查询新闻信息",notes = "公告新闻的查询")
    public ResultData selectNews(@RequestParam HashMap hashMap){
        ResultData resultData = newsService.selectNews(hashMap);
        return resultData;
    }

    /**
     * @Description: 添加一条新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:21
     **/
    @PostMapping("/insertNews")
    public ResultData insertNews(@RequestParam Map map){
        ResultData resultData = newsService.insertNews(map);
        return resultData;
    }

    /**
     * @Description: 修改新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:21
     **/
    @PostMapping("/updateNews")
    public ResultData updateNews(@RequestBody Map map){
        ResultData resultData = newsService.updateNews(map);
        return resultData;
    }

    /**
     * @Description: 批量删除新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:21
     **/
    @PostMapping("/deleteNews")
    public ResultData deleteNews(@RequestParam String ids){
        ResultData resultData = newsService.deleteNews(ids);
        return resultData;
    }

    /**
     * @Description: 删除一条新闻信息
     * @Author: Bing
     * @Date: 2020/7/16 11:20
     **/
    @PostMapping("/deleteOneNews")
    public ResultData deleteOneNews(@RequestBody Map map){
        ResultData resultData = newsService.deleteOneNews(map);
        return resultData;
    }
}
