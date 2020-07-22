package com.qwz.mapper;

import com.qwz.model.Dict;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface DictMapper extends Mapper<Dict> {
    /**
     * 条件查询字典列表
     */
    List<Dict> allDict(Map map);
}