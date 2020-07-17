package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.NewsMapper;
import com.qwz.model.News;
import com.qwz.utils.IDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
    public PageInfo selectNewss(String title,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo pageInfo = new PageInfo(newsMapper.selectNewss(title));
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
        //生成ID
        news.setId(Long.valueOf(IDUtils.getNum18()));
        //创建时间
        news.setGmtCreate(new Date());
        //判断是否获取值
        if (news != null && !"".equals(news)){
            try {
                int insert = newsMapper.insert(news);
                if (insert > 0){
                    return insert;
                }
                return -1;
            }catch (Exception e){
                e.printStackTrace();
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
        //获取修改时间
        news.setGmtModified(new Date());
        //判断是否获取值
        if (news != null && "".equals(news)){
            try{
                int update = newsMapper.updateByPrimaryKey(news);
                if (update > 0){
                    return update;
                }
                return -1;
            }catch (Exception e){
                e.printStackTrace();
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

    /**
     * @Description:  根据主键批量删除
     * @Author: Bing
     * @Date: 2020/7/17 14:47
     **/
    public Integer delectListNews(List<Integer> ids){
        Example example=Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return newsMapper.deleteByPrimaryKey(example);
    }
}
