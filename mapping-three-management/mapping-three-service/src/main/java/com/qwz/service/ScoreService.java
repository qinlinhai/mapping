package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.ScoreMapper;
import com.qwz.model.Score;
import com.qwz.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService extends BaseService<Score> {
    @Autowired
    private ScoreMapper scoreMapper;
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 向单位分值表中插入一条数据
     **/
    public Boolean addUnitScore(Score score){
        score.setId(Long.valueOf(IDUtils.getNum18()));
        if(score!=null){
            Integer insert = super.insert(score);
            if(insert>0){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据单位id查询评分记录
     **/

    public PageInfo selectListScoreByUnitId(Score score,Integer currentPage,Integer pageSize){
        if(currentPage!=null && pageSize!=null){
            PageHelper.startPage(currentPage,pageSize);
        }
        if(score!=null){
            List<Score> scores = super.selectList(score);
            if(scores!=null){
                PageInfo<Score> scorePageInfo = new PageInfo<Score>(scores);
                if(scorePageInfo!=null){
                    return scorePageInfo;
                }else{
                    return null;
                }
            }
        }
        return null;
    }
}
