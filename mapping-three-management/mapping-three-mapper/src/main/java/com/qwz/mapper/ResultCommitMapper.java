package com.qwz.mapper;

import com.qwz.model.ResultCommit;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface ResultCommitMapper extends Mapper<ResultCommit> {
}