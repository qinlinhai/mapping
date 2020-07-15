package com.qwz.service;

import com.qwz.base.BaseService;
import com.qwz.mapper.MappingUnitMapper;
import com.qwz.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class MappingUnitService  extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;


}
