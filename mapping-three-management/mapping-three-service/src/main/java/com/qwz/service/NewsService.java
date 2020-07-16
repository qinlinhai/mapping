package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.NewsMapper;
import com.qwz.model.News;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author: Bing
 * @time: 2020/7/15 16:54
 */
@Service
@Slf4j
public class NewsService extends BaseService<News> {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * @Description: 查询新闻信息
     * @Author: Bing
     * @Date: 2020/7/15 17:15
     **/
    public PageInfo selectNews(HashMap hashMap){
        PageHelper.startPage(Integer.parseInt(hashMap.get("pageNumber")+""),Integer.parseInt(hashMap.get("pageSize")+""));
        PageInfo pageInfo = new PageInfo(newsMapper.selectAll());
        if (null != pageInfo && !"".equals(pageInfo)){
            return pageInfo;
        }
        return null;
    }

    /**
     * @Description: 添加公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:05
     **/
    public Integer insertNews(News news){
        if (news != null && !"".equals(news)){
            int insert = newsMapper.insert(news);
                if (insert > 0){
                    return insert;
                }
        }
        return -1;
    }

    /**
     * @Description: 修改公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:07
     **/
    public Integer updateNews(News news){
        if (news != null && "".equals(news)){
            int update = newsMapper.updateByPrimaryKey(news);
            if (update > 0){
                return update;
            }
        }
        return -1;
    }

    /**
     * @Description: 删除公告新闻
     * @Author: Bing
     * @Date: 2020/7/16 9:12
     **/
    public Integer delectNews(String newsid){
        int i = newsMapper.deleteByPrimaryKey(newsid);
        if (i > 0){
            return i;
        }
        return -1;
    }
}
