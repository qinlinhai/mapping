package com.qwz.controller;

import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.ResultCommit;
import com.qwz.service.ResultCommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ResultCommitController extends CommonController<ResultCommit> {
    @Override
    public BaseService<ResultCommit> getBaseService() {
        return null;
    }


    @Autowired
    private ResultCommitService resultCommitService;


    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 根据 成果名称 项目类型  成果日期
     **/
    @GetMapping("/selectResultCommitByNmeAndTypeAndDate")
    public ResultData selectResultCommitByNmeAndTypeAndDate(@RequestParam("name") String name, @RequestParam("type") String type,
                                                            @RequestParam("date") String date){
        List<Map> maps = resultCommitService.selectResultCommitByNmeAndTypeAndDate(name, type, date);
        if(maps!=null && maps.size()>0){
            return super.selectSuccess(maps);
        }else{
            return super.selectFailed();
        }
    }
}
