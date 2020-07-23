package com.qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.CommonController;
import com.qwz.base.ResultData;
import com.qwz.model.CheckPerson;
import com.qwz.service.CheckPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/16 16:16
 */
@RestController
public class CheckPersonController extends CommonController<CheckPerson> {

    @Autowired
    private CheckPersonService checkPersonService;

    public BaseService<CheckPerson> getBaseService() {
        return checkPersonService;
    }

    /**
     * @Description: 查询抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:19
     **/
    @PostMapping("/selectCheckPerson")
    public ResultData selectCheckPerson(@RequestParam("random") double random,@RequestParam("pageNumber") Integer pageNumber,
                                        @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = checkPersonService.selectCheckPerson(random, pageNumber, pageSize);
        if (null != pageInfo && !"".equals(pageInfo)){
            return super.selectSuccess(pageInfo);
        }else {
            return super.selectFailed();
        }
    }

    /**
     * @Description: 添加抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:55
     **/
    @PostMapping("/insertCheckPerson")
    public ResultData insertCheckPerson(@RequestBody CheckPerson checkPerson){
        checkPerson.setCreateTime(new Date());
        Integer integer = checkPersonService.insertCheckPerson(checkPerson);
        if (integer > 0){
            return super.addSuccess(integer);
        }else {
            return super.addFailed();
        }
    }

    /**
     * @Description: 修改抽查人员信息
     * @Author: Bing
     * @Date: 2020/7/16 16:56
     **/
    @PostMapping("/updateCheckPerson")
    public ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson){
        checkPerson.setModifyTime(new Date());
        Integer integer = checkPersonService.updateCheckPerson(checkPerson);
        if (integer > 0){
            return super.updateSuccess(integer);
        }else {
            return super.updateFailed();
        }
    }

    /**
     * @Description: 删除抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 16:57
     **/
    @PostMapping("/delectOneCheckPerson")
    public ResultData delectOneCheckPerson(@RequestParam("id") String id){
        Integer integer = checkPersonService.delectCheckPerson(id);
        if (integer > 0){
            return super.deleteSuccess(integer);
        }else {
            return super.deleteFailed();
        }
    }

    /**
     * @Description: 批量删除抽查人员
     * @Author: Bing
     * @Date: 2020/7/16 17:01
     **/
    @PostMapping("/delectListCheckPerson")
    public ResultData delectListCheckPerson(@RequestParam("ids") String ids){
        return deleteByIds(ids);
    }
}
