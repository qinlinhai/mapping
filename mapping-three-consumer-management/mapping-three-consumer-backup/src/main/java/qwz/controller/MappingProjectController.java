package qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.base.ResultData;
import com.qwz.model.MappingProject;
import com.qwz.service.IProjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功登记的项目信息
     **/
    @GetMapping("/selectSuccessRegister")
    public ResultData selectSuccessRegister(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("searchName") String searchName){
        return iProjectService.selectSuccessRegister(currentPage,pageSize,searchName);
    }
    /**
     * @author  qlh
     * @date   2020/7/14
     * @desc
     * 查询成功汇交的项目信息
     **/
    @GetMapping("/selectSuccessRemittance")
    public ResultData selectSuccessRemittance(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
                                       @RequestParam("searchName") String searchName){
        return iProjectService.selectSuccessRemittance(currentPage,pageSize,searchName);
    }

    /**
     * 根据项目id查询次项目的详细信息
     * @param projectId
     * @return
     */
    @GetMapping("/selectSuccessRegisterById")
    public ResultData selectSuccessRegisterById(@RequestParam("projectId") Long projectId){
        return iProjectService.selectSuccessRegisterById(projectId);
    }
    /**
     * @author  qlh
     * @date   2020/7/15
     * @desc
     * 通过项目id查询项目以及附件
     **/
    @GetMapping("/selectProjectandResource")
    public ResultData selectProjectandResource(@RequestParam("projectId") Long projectId){
        return iProjectService.selectProjectandResource(projectId);
    }
    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 查询汇交结果 通过id
     **/

    @PostMapping("/selectResultCommitById")
    public ResultData selectResultCommitById(@RequestParam Long id){
        return iProjectService.selectResultCommitById(id);
    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     *  查询未审核的项目
     **/
    @GetMapping("/selectNoAudit")
    public ResultData selectNoAudit (@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
                              @RequestParam("projectName") String projectName){
        return iProjectService.selectNoAudit(currentPage,pageSize,projectName);
    }
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 查询为汇交的项目
     **/
    @GetMapping("/selectNoRemittance")
    public ResultData selectNoRemittance(@RequestParam("currentPage")Integer currentPage,@RequestParam("pageSize")Integer pageSize,
                                  @RequestParam("projectName") String projectName){
        return iProjectService.selectNoRemittance(currentPage,pageSize,projectName);
    }
    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 给项目审核通过
     **/
    @PostMapping("/updateMappingProjectAuditStatus")
    public ResultData updateMappingProjectAuditStatus(@RequestBody MappingProject mappingProject){
        return iProjectService.updateMappingProjectAuditStatus(mappingProject);
    }

    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     *
     * 查询 已完成 和未完成的 项目类型
     **/
    @GetMapping("/selectPRojectByType")
    public ResultData selectPRojectByType(){
        return iProjectService.selectPRojectByType();
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据userId查询单位所属项目
     **/
    @GetMapping("/selectProjectByUserId")
    public ResultData selectProjectByUserId(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("userId") Integer userId){
        return iProjectService.selectProjectByUserId(currentPage,pageSize,userId);
    }
    
}
