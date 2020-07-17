package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.PrincipalMapper;
import com.qwz.model.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据id查询负责人信息
     **/
    public PageInfo selectOneByUserId(Integer userId,Integer currentPage,Integer pageSize){
       if(currentPage!=null && !"".equals(currentPage) && pageSize!=null && !"".equals(pageSize)){
           PageHelper.startPage(currentPage,pageSize);
           if(userId!=null && !"".equals(userId)){
               List<Principal> principals = principalMapper.selectPrincipal(userId);
               PageInfo<Principal> principalPageInfo = new PageInfo<Principal>(principals);
               if(principalPageInfo!=null){
                   return principalPageInfo;
               }else{
                   return null;
               }
           }
       }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据负责人id查询负责新详细信息以及附件
     **/
    public List<Map> selectPrincipalEnclosure(Long principal){
        if (principal!=null && !"".equals(principal)){
            List<Map> maps = principalMapper.selectPrincipalEnclosure(principal);
            if(maps!=null && maps.size()>0){
                return maps;
            }
        }
        return null;
    }
}
