package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.base.ResultData;
import com.qwz.mapper.MenuMapper;
import com.qwz.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WCX
 * @data 2020/7/16 8:48
 * @describe
 */
@Service
public class MenuService extends BaseService<Menu> {
    @Autowired
    private MenuMapper menuMapper;
    /**
     * 查询菜单列表
     */
    public ResultData allMenu(){
        List<Menu> menus = menuMapper.selectAll();
        ResultData resultData=new ResultData();
        resultData.setData(menus);
        return resultData;
    }
}
