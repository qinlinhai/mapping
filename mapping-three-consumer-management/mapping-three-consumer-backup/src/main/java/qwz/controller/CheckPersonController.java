package qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.model.CheckPerson;
import com.qwz.service.IProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 20:04
 */
@RestController
public class CheckPersonController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectCheckPerson")
    @ApiOperation(value = "分页查询抽查人员信息",notes = "抽查人员的查询")
    public ResultData selectCheckPerson(@RequestParam HashMap hashMap){
        ResultData resultData = iProjectService.selectCheckPerson(hashMap);
        return resultData;
    }

    @PostMapping("/insertCheckPerson")
    @ApiOperation(value = "添加抽查人员信息",notes = "抽查人员的添加")
    public ResultData insertCheckPerson(@RequestBody CheckPerson checkPerson){
        ResultData resultData = iProjectService.insertCheckPerson(checkPerson);
        return resultData;
    }

    @PostMapping("/updateCheckPerson")
    @ApiOperation(value = "修改抽查人员信息",notes = "抽查人员的修改")
    public ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson){
        ResultData resultData = iProjectService.updateCheckPerson(checkPerson);
        return resultData;
    }

    @PostMapping("/delectOneCheckPerson")
    @ApiOperation(value = "删除抽查人员信息",notes = "抽查人员的删除")
    public ResultData delectOneCheckPerson(@RequestParam String id){
        ResultData resultData = iProjectService.delectOneCheckPerson(id);
        return resultData;
    }
}
