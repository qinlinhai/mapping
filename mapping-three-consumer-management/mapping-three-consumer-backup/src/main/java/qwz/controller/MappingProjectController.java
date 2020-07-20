package qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.model.MappingProject;
import com.qwz.service.IProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 19:55
 */
@RestController
public class MappingProjectController {

    @Autowired
    private IProjectService iProjectService;

    @PostMapping("/selectAdm")
    public ResultData selectAdm(@RequestParam String projectType, @RequestParam Integer userid,
                                @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        ResultData resultData = iProjectService.selectAdm(projectType, userid, pageNumber, pageSize);
        return resultData;
    }

    @PostMapping("/insertAdm")
    public ResultData insertAdm(@RequestBody MappingProject mappingProject){
        ResultData resultData = iProjectService.insertAdm(mappingProject);
        return resultData;
    }

    @PostMapping("/updateAdm")
    public ResultData updateAdm(@RequestBody MappingProject mappingProject){
        ResultData resultData = iProjectService.updateAdm(mappingProject);
        return resultData;
    }

    @PostMapping("/deleteAdm")
    public ResultData deleteAdm(@RequestParam Long id){
        ResultData resultData = iProjectService.deleteAdm(id);
        return resultData;
    }

    @PostMapping("/selectRem")
    public ResultData selectRem(@RequestParam String projectType,@RequestParam Integer userid,
                                @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        ResultData resultData = iProjectService.selectRem(projectType, userid, pageNumber, pageSize);
        return resultData;
    }

    @PostMapping("/updateRem")
    public ResultData updateRem(@RequestBody MappingProject mappingProject){
        ResultData resultData = iProjectService.updateRem(mappingProject);
        return resultData;
    }
}
