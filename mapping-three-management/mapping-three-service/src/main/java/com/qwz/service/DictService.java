package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.DictMapper;
import com.qwz.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/17 10:59
 * @describe
 */
@Service
public class DictService extends BaseService<Dict> {
    @Autowired
    private DictMapper dictMapper;
    /**
     * 分页展示字典数据
     */
    public PageInfo<Dict> allDict(Map map){
        PageHelper.startPage(Integer.parseInt(map.get("page").toString()),Integer.parseInt(map.get("limit").toString()));
        List<Dict> dicts = dictMapper.allDict(map);
        PageInfo pageInfo=new PageInfo(dicts);
        return pageInfo;
    }

}
