package com.qwz.service;

import com.qwz.base.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/15 18:43
 */
@FeignClient(value = "")
public interface NewsService {

    /**
     * @Description: 查询公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:17
     **/
    @PostMapping("/selectNews")
    ResultData selectNews(@RequestParam HashMap hashMap);

    /**
     * @Description: 添加公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:17
     **/
    @PostMapping("/insertNews")
    ResultData insertNews(@RequestParam Map map);

    /**
     * @Description: 修改公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:17
     **/
    @PostMapping("/updateNews")
    ResultData updateNews(@RequestBody Map map);

    /**
     * @Description: 批量删除公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:22
     **/
    @PostMapping("/deleteNews")
    ResultData deleteNews(@RequestParam String ids);

    /**
     * @Description: 删除一条公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 11:16
     **/
    @PostMapping("/deleteOneNews")
    ResultData deleteOneNews(@RequestBody Map map);
}
