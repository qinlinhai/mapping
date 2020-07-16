package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.mapper.ResultCommitMapper;
import com.qwz.model.ResultCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultCommitService extends BaseService<ResultCommit> {

    @Autowired
    private ResultCommitMapper resultCommitMapper;

    public List<ResultCommit> selectResultCommitById(ResultCommit resultCommit){
        if(resultCommit!=null && !"".equals(resultCommit)){
           return super.selectList(resultCommit);
        }
        return null;
    }
}
