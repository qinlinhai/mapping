package qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.service.IProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 19:52
 */
@RestController
public class MappingUnitController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectBlackUnit")
    @ApiOperation(value = "分页查询黑名单",notes = "黑名单的查询")
    public ResultData selectBlackUnit(@RequestParam HashMap hashMap){
        ResultData resultData = iProjectService.selectBlackUnit(hashMap);
        return resultData;
    }

    @PostMapping("/selectWhiteUnit")
    @ApiOperation(value = "分页查询白名单",notes = "白名单的查询")
    public ResultData selectWhiteUnit(@RequestParam HashMap hashMap){
        ResultData resultData = iProjectService.selectWhiteUnit(hashMap);
        return resultData;
    }
}
