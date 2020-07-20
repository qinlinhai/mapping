package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.TechnicistMapper;
import com.qwz.model.Technicist;
import com.qwz.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    /**
     * @Description: 添加技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/20 20:35
     **/
    public Integer insertTec(Technicist technicist,Long userid){
        technicist.setId(Long.valueOf(IDUtils.getNum18()));
        technicist.setCreateTime(new Date());
        technicist.setUserId(userid);
        if (technicist != null && !"".equals(technicist)){
            int insert = technicistMapper.insert(technicist);
            if (insert > 0) {
                return insert;
            }
        }
        return -1;
    }

    /**
     * @Description: 修改技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/20 20:38
     **/
    public Integer updateTec(Technicist technicist){
        technicist.setModifyTime(new Date());
        if (technicist != null && !"".equals(technicist)){
            int update = technicistMapper.updateByPrimaryKey(technicist);
            if (update > 0){
                return update;
            }
        }
        return -1;
    }

    /**
     * @Description: 删除技术人员基础信息
     * @Author: Bing
     * @Date: 2020/7/20 20:39
     **/
    public Integer deleteTec(Long id){
        int i = technicistMapper.deleteByPrimaryKey(id);
        if (i > 0){
            return i;
        }else {
            return -1;
        }
    }
}
