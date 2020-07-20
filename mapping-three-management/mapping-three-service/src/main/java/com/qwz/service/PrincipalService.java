package com.qwz.service;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.PrincipalMapper;
import com.qwz.model.Principal;
import com.qwz.utils.IDUtils;
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
    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 新增一条单位负责人信息
     **/
    public Boolean addPrincipal(Principal principal){
        if(principal!=null){
            Integer insert = super.insert(principal);
            if(insert>0){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 修改单位负责人信息
     **/
    public Boolean updatePrincipal(Principal principal){
        if(principal!=null){
            Integer update = super.update(principal);
            if(update>0){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 删除单位负责人
     **/
    public  Boolean deletePrincipal(Principal principal){
        if(principal!=null){
            Integer integer = super.deleteByPrimaryKey(principal);
            if(integer>0){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }



}
