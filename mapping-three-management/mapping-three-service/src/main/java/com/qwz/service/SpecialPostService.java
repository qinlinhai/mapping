package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.SpecialPostMapper;
import com.qwz.model.SpecialPost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:22
 */
@Service
@Slf4j
public class SpecialPostService extends BaseService<SpecialPost> {

    @Autowired
    private SpecialPostMapper specialPostMapper;

    /**
     * @Description: 根据userid查询特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/17 16:26
     **/
    public PageInfo selectSpecial(Integer userid,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<SpecialPost> specialPosts = specialPostMapper.selectSpecial(userid);
        PageInfo pageInfo = new PageInfo(specialPosts);
        return pageInfo;
    }

    /**
     * @Description: 根据id查询特殊人员基本信息
     * @Author: Bing
     * @Date: 2020/7/17 19:34
     **/
    public List<SpecialPost> selectIdSpecial(Long id){
        List<SpecialPost> specialPosts = specialPostMapper.selectIdSpecial(id);
        return specialPosts;
    }
}
