package com.qwz.mapper;

import com.qwz.model.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/14 16:11
 */
public interface UserMapper extends Mapper<User> {

    List<HashMap> selectUserAll(HashMap map);
    /**
     * 条件查询所有用户信息
     */
    List<Map> allUser(Map map);
}
