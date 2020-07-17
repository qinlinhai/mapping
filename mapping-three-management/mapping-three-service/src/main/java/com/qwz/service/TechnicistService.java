package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.TechnicistMapper;
import com.qwz.model.Technicist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 16:00
 */
@Service
public class TechnicistService extends BaseService<Technicist> {

    @Autowired
    private TechnicistMapper technicistMapper;

    /**
     * @Description: 根据userid查询技术人员信息
     * @Author: Bing
     * @Date: 2020/7/17 16:03
     **/
    public PageInfo selectTec(Integer userid,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<Technicist> technicists = technicistMapper.selectTec(userid);
        PageInfo pageInfo = new PageInfo(technicists);
        return pageInfo;
    }

    /**
     * @Description: 根据id查询技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/17 16:36
     **/
    public List<Technicist> selectOneTec(Long id){
        List<Technicist> technicists = technicistMapper.selectOneTec(id);
        return technicists;
    }
}
