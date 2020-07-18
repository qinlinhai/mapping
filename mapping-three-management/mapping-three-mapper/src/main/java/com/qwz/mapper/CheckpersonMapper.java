package com.qwz.mapper;

import com.qwz.model.CheckPerson;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface CheckpersonMapper extends Mapper<CheckPerson> {

    /**
     * @Description: 查询抽查人员名单
     * @Author: Bing
     * @Date: 2020/7/16 16:17
     **/
    List<CheckPerson> selectCheckPerson(@Param("random") Integer random);

    /**
     * @Description: 查询抽查人员名单总数
     * @Author: Bing
     * @Date: 2020/7/18 10:01
     **/
    @Select("select count(1) from t_check_person")
    int selectHang();


}