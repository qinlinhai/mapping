package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.mapper.ResultCommitMapper;
import com.qwz.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResultCommitService extends BaseService<ResultCommit> {

    @Autowired
    private ResultCommitMapper resultCommitMapper;

    public ResultCommit selectResultCommitById(Long id){
        if(id != null && !"".equals(id)){

            return resultCommitMapper.selectOneData(id);
        }else{
            return null;
        }

    }


    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 根据 成果名称 项目类型  成果日期
     **/

    public List<Map> selectResultCommitByNmeAndTypeAndDate(String name,String type,String date){
        List<Map> maps = resultCommitMapper.selectResultCommitByNmeAndTypeAndDate(name, type, date);
        if(maps!=null && maps.size()>0){
            return maps;
        }else{
            return null;
        }
    }
}
