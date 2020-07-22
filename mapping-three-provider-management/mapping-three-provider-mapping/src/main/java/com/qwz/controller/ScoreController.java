package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.MappingUnit;
import com.qwz.model.Score;
import com.qwz.service.MappingUnitService;
import com.qwz.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController extends CommonController<Score> {

    @Override
    public BaseService<Score> getBaseService() {
        return null;
    }
    @Autowired
    private ScoreService scoreService;
    @Autowired
    private MappingUnitService mappingUnitService;

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 修改单位分值+插入单位分值表
     **/
    @PostMapping("/addUnitScore")
    public ResultData addUnitScore(@RequestBody Score score){
        Boolean aBoolean = scoreService.addUnitScore(score);
        Boolean aBoolean1 = mappingUnitService.updateUnitScore(score.getScore(),score.getUnitId());
        if(aBoolean && aBoolean1){
            return super.addSuccess("向单位分支表中插入数据成功");
        }else{
            return super.addFailed();
        }
    }
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据id查询评分表成功
     **/
    @PostMapping("/selectListScoreByUnitId")
    public ResultData selectListScoreByUnitId(@RequestBody Score score, @RequestParam("currentPage") Integer currentPage,
                                              @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = scoreService.selectListScoreByUnitId(score, currentPage, pageSize);
        if(pageInfo!=null){
            return super.selectSuccess("根据id查询评分表成功",pageInfo);
        }else{
            return super.selectFailed();
        }
    }
}
