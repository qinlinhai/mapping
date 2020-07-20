package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.ResourceMapper;
import com.qwz.mapper.SpecialPostMapper;
import com.qwz.model.Resource;
import com.qwz.model.SpecialPost;
import com.qwz.utils.IDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private ResourceMapper resourceMapper;

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

    /**
     * @Description: 添加特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/20 21:21
     **/
    public Boolean insertSpecial(SpecialPost specialPost,String path,Long userid){
        specialPost.setId(Long.valueOf(IDUtils.getNum18()));
        specialPost.setCreateTime(new Date());
        specialPost.setUserId(userid);
        if (specialPost != null && !"".equals(specialPost)){
            int insert = specialPostMapper.insert(specialPost);
            if (insert > 0){
                Resource resource = new Resource();
                resource.setId(Long.valueOf(IDUtils.getNum18()));
                resource.setCreateTime(new Date());
                resource.setRefBizId(specialPost.getId());
                resource.setExtName(path.substring(path.indexOf("."),path.length()));
                int insert1 = resourceMapper.insert(resource);
                if (insert1 > 0){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @Description: 修改特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/20 21:25
     **/
    public Boolean updateSpecial(SpecialPost specialPost){
        specialPost.setModifyTime(new Date());
        if (specialPost != null && !"".equals(specialPost)){
            int update = specialPostMapper.updateByPrimaryKey(specialPost);
            if (update > 0){
                Resource resource = new Resource();
                resource.setModifyTime(new Date());
                int update1 = resourceMapper.updateByPrimaryKey(resource);
                if (update > 0){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * @Description: 删除特殊人员信息
     * @Author: Bing
     * @Date: 2020/7/20 21:26
     **/
    public Integer deleteSpecial(Long id){
        int i = specialPostMapper.deleteByPrimaryKey(id);
        if (i > 0){
            return i;
        }else {
            return -1;
        }
    }
}
