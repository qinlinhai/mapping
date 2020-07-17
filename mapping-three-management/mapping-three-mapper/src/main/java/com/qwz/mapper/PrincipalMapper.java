package com.qwz.mapper;

import com.qwz.model.Principal;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface PrincipalMapper extends Mapper<Principal> {

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据userId查询负责人信息
     **/
    List<Principal> selectPrincipal(Integer userId);

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据 负责人id查询负责详细信息以及附件
     **/

    List<Map> selectPrincipalEnclosure(Long principalId);
}