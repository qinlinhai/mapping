package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.model.Score;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
    @Autowired
    private IProjectService iProjectService;
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 修改单位分值+插入单位分值表
//     **/
//    @PostMapping("/addUnitScore")
//    public ResultData addUnitScore(@RequestBody Score score){
//    return iProjectService.addUnitScore(score);
//    }
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据id查询评分表成功
     **/
    @PostMapping("/selectListScoreByUnitId")
    public ResultData selectListScoreByUnitId(@RequestBody Score score,@RequestParam("currentPage") Integer currentPage,
                                              @RequestParam("pageSize") Integer pageSize){
       return iProjectService.selectListScoreByUnitId(score,currentPage,pageSize);
    }
}
