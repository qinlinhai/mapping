package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.UserMapper;
import com.qwz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/16 22:04
 * @describe
 */
@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;
    /**
     * 分页查询所有用户
     */
    public PageInfo<Map> allUser(Integer page,Integer limit,Map map){
        PageHelper.offsetPage((page-1)*limit,limit);
        List<Map> list = userMapper.allUser(map);
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
}
