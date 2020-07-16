package com.qwz.mapper;

import com.qwz.model.CheckPerson;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CheckpersonMapper extends Mapper<CheckPerson> {

    /**
     * @Description: 查询抽查人员名单
     * @Author: Bing
     * @Date: 2020/7/16 16:17
     **/
    List<CheckPerson> selectCheckPerson();
}