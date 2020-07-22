package com.qwz.service;

import com.qwz.base.ResultData;
import com.qwz.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "mapping-interface")
public interface IProjectService {
//    /**
//     * @Description: 执行登录操作
//     * @Author: Bing
//     * @Date: 2020/7/15 15:14
//     **/
//    @PostMapping("/doLogin")
//    ResultData doLogin(@RequestBody User user);
//
//    /**
//     * @Description: 新增日志
//     * @Author: Bing
//     * @Date: 2020/7/15 15:18
//     **/
//    @PostMapping("/addLoginLog")
//    Integer addLoginLog(@RequestBody LoginLog loginLog);
//
//    /**
//     * @Description: 查询公告新闻
//     * @Author: Bing
//     * @Date: 2020/7/16 11:17
//     **/
//    @PostMapping("/selectNews")
//    ResultData selectNews(@RequestParam String title,@RequestParam Integer pageNumber,
//                          @RequestParam Integer pageSize);
//
//    /**
//     * @Description: 添加公告新闻
//     * @Author: Bing
//     * @Date: 2020/7/16 11:17
//     **/
//    @PostMapping("/insertNews")
//    ResultData insertNews(@RequestParam Map map);
//
//    /**
//     * @Description: 修改公告新闻
//     * @Author: Bing
//     * @Date: 2020/7/16 11:17
//     **/
//    @PostMapping("/updateNews")
//    ResultData updateNews(@RequestBody Map map);
//
//    /**
//     * @Description: 批量删除公告新闻
//     * @Author: Bing
//     * @Date: 2020/7/16 9:22
//     **/
//    @PostMapping("/deleteNews")
//    ResultData deleteNews(@RequestParam String ids);
//
//    /**
//     * @Description: 删除一条公告新闻
//     * @Author: Bing
//     * @Date: 2020/7/16 11:16
//     **/
//    @PostMapping("/deleteOneNews")
//    ResultData deleteOneNews(@RequestBody Map map);
//
//    /**
//     * @Description: 项目管理  查询登录用户管理的项目
//     * @Author: Bing
//     * @Date: 2020/7/16 21:49
//     **/
//    @PostMapping("/selectAdm")
//    ResultData selectAdm(@RequestParam String projectType,@RequestParam Integer userid,
//                         @RequestParam Integer pageNumber, @RequestParam Integer pageSize);
//
//    /**
//     * @Description: 项目管理，添加项目
//     * @Author: Bing
//     * @Date: 2020/7/16 22:06
//     **/
//    @PostMapping("/insertAdm")
//    ResultData insertAdm(@RequestBody MappingProject mappingProject);
//
//    /**
//     * @Description: 项目管理  修改项目
//     * @Author: Bing
//     * @Date: 2020/7/17 10:44
//     **/
//    @PostMapping("/updateAdm")
//    ResultData updateAdm(@RequestBody MappingProject mappingProject);
//
//    /**
//     * @Description:  项目管理  删除项目
//     * @Author: Bing
//     * @Date: 2020/7/17 10:46
//     **/
//    @PostMapping("/deleteAdm")
//    ResultData deleteAdm(@RequestParam Long id);
//
//    /**
//     * @Description: 项目汇交  条件查询
//     * @Author: Bing
//     * @Date: 2020/7/17 11:04
//     **/
//    @PostMapping("/selectAdm")
//    ResultData selectRem(@RequestParam String projectType,@RequestParam Integer userid,
//                         @RequestParam Integer pageNumber, @RequestParam Integer pageSize);
//
//    /**
//     * @Description: 项目汇交  修改项目
//     * @Author: Bing
//     * @Date: 2020/7/17 11:13
//     **/
//    @PostMapping("/updateRem")
//    ResultData updateRem(@RequestBody MappingProject mappingProject);
//
//    /**
//     * @Description: 查询抽查人员
//     * @Author: Bing
//     * @Date: 2020/7/16 16:19
//     **/
//    @PostMapping("/selectCheckPerson")
//    ResultData selectCheckPerson(@RequestParam HashMap hashMap);
//
//    /**
//     * @Description: 添加抽查人员
//     * @Author: Bing
//     * @Date: 2020/7/16 16:55
//     **/
//    @PostMapping("/insertCheckPerson")
//    ResultData insertCheckPerson(@RequestBody CheckPerson checkPerson);
//
//    /**
//     * @Description: 修改抽查人员信息
//     * @Author: Bing
//     * @Date: 2020/7/16 16:56
//     **/
//    @PostMapping("/updateCheckPerson")
//    ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson);
//
//    /**
//     * @Description: 删除抽查人员
//     * @Author: Bing
//     * @Date: 2020/7/16 16:57
//     **/
//    @PostMapping("/delectOneCheckPerson")
//    ResultData delectOneCheckPerson(@RequestParam String id);
//
//    /**
//     * @Description: 批量删除抽查人员
//     * @Author: Bing
//     * @Date: 2020/7/16 17:01
//     **/
//    @PostMapping("/delectListCheckPerson")
//    ResultData delectListCheckPerson(@RequestParam String ids);
//
//    /**
//     * @Description: 查询白名单
//     * @Author: Bing
//     * @Date: 2020/7/16 11:46
//     **/
//    @PostMapping("/selectWhiteUnit")
//    ResultData selectWhiteUnit(@RequestParam HashMap hashMap);
//
//    /**
//     * @Description: 查询黑名单
//     * @Author: Bing
//     * @Date: 2020/7/16 11:46
//     **/
//    @PostMapping("/selectBlackUnit")
//    ResultData selectBlackUnit(@RequestParam HashMap hashMap);
//
//    /**
//     * @Description: 根据userid查询仪器设备信息
//     * @Author: Bing
//     * @Date: 2020/7/17 16:32
//     **/
//    @PostMapping("/selectEquipment")
//    ResultData selectEquipment(@RequestParam Integer userid,@RequestParam Integer pageNumber,
//                               @RequestParam Integer pageSize);
//
//    /**
//     * @Description: 根据id查询仪器设备基本信息
//     * @Author: Bing
//     * @Date: 2020/7/17 19:38
//     **/
//    @PostMapping("/selectIdEquipment")
//    ResultData selectIdEquipment(@RequestParam Long id);
//
    @PostMapping("/selectTec")
    ResultData selectTec(@RequestParam("userid") Integer userid,@RequestParam("pageNumber") Integer pageNumber,
                         @RequestParam("pageSize") Integer pageSize);
//
//    @PostMapping("/selectOneTec")
//    ResultData selectOneTec(@RequestParam Long id);
//
//    @PostMapping("/selectSpecial")
//    ResultData selectSpecial(@RequestParam Integer userid,@RequestParam Integer pageNumber,
//                             @RequestParam Integer pageSize);
//
//    @PostMapping("/selectIdSpecial")
//    ResultData selectIdSpecial(@RequestParam Long id);
//
//
////    /**
////     * @author  qlh
////     * @date   2020/7/16
////     * @desc
////     * 项目登记审核
////     **/
////    @PostMapping("/auditMappingProjectRegister")
////    ResultData auditMappingProjectRegister(@RequestBody Audit audit, @RequestParam("id") Long id, @RequestParam("auditStatus") Integer auditStatus);
//
////    /**
////     * @author  qlh
////     * @date   2020/7/16
////     * @desc
////     * 项目汇交审核
////     **/
////    @PostMapping("/auditMappingProjectRemittance")
////    ResultData auditMappingProjectRemittance(@RequestBody Audit audit, @RequestParam("id") Long id,@RequestParam("resultStatus") Integer resultStatus);
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据单位id查询单位审核记录
//     **/
//    @GetMapping("/selectUnitAuditByUnitId")
//    ResultData selectUnitAuditByUnitId(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
//                                       @RequestParam("unitId") Long unitId);
//
////    /**
////     * @author  qlh
////     * @date   2020/7/17
////     * @desc
////     * 审核待修改审核
////     **/
////    @PostMapping("/updateUnitStatus")
////    ResultData updateUnitStatus(@RequestBody Audit audit,@RequestParam("unitId") Long unitId,@RequestParam("auditStatus") Integer auditStatus);
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据业务编号查询类型为项目登记审核的审核记录
//     **/
//    @GetMapping("/selectProjectAuditByRefId")
//    ResultData selectProjectAuditByRefId(@RequestParam("refId") Long refId,@RequestParam("currentPage") Integer currentPage,
//                                         @RequestParam("pageSize") Integer pageSize);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据业务编号查询类型为项目汇交审核的审核记录
//     **/
//    @GetMapping("/selectProjectRemittanceByRefId")
//    ResultData selectProjectRemittanceByRefId(@RequestParam("refId") Long refId,@RequestParam("currentPage") Integer currentPage,
//                                              @RequestParam("pageSize") Integer pageSize);
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/14
//     * @desc
//     * 查询成功登记的项目信息
//     **/
//    @GetMapping("/selectSuccessRegister")
//    ResultData selectSuccessRegister(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
//                                     @RequestParam("searchName") String searchName);
//    /**
//     * @author  qlh
//     * @date   2020/7/14
//     * @desc
//     * 查询成功汇交的项目信息
//     **/
//    @GetMapping("/selectSuccessRemittance")
//    ResultData selectSuccessRemittance(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize,
//                                       @RequestParam("searchName") String searchName);
//
//    /**
//     * 根据项目id查询次项目的详细信息
//     * @param projectId
//     * @return
//     */
//    @GetMapping("/selectSuccessRegisterById")
//    ResultData selectSuccessRegisterById(@RequestParam("projectId") Long projectId);
//    /**
//     * @author  qlh
//     * @date   2020/7/15
//     * @desc
//     * 通过项目id查询项目以及附件
//     **/
//    @GetMapping("/selectProjectandResource")
//    ResultData selectProjectandResource(@RequestParam("projectId") Long projectId);
//    /**
//     * @author  qlh
//     * @date   2020/7/20
//     * @desc
//     * 查询汇交结果 通过id
//     **/
//
//    @PostMapping("/selectResultCommitById")
//    ResultData selectResultCommitById(@RequestParam Long id);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     *  查询未审核的项目
//     **/
//    @GetMapping("/selectNoAudit")
//    ResultData selectNoAudit (@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
//                              @RequestParam("projectName") String projectName);
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 查询为汇交的项目
//     **/
//    @GetMapping("/selectNoRemittance")
//    ResultData selectNoRemittance(@RequestParam("currentPage")Integer currentPage,@RequestParam("pageSize")Integer pageSize,
//                                  @RequestParam("projectName") String projectName);
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 给项目审核通过
//     **/
//    @PostMapping("/updateMappingProjectAuditStatus")
//    ResultData updateMappingProjectAuditStatus(@RequestBody MappingProject mappingProject);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     *
//     * 查询 已完成 和未完成的 项目类型
//     **/
//    @GetMapping("/selectPRojectByType")
//    ResultData selectPRojectByType();
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据userId查询单位所属项目
//     **/
//    @GetMapping("/selectProjectByUserId")
//    ResultData selectProjectByUserId(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
//                                     @RequestParam("userId") Integer userId);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 查询所有的 单位资质数据
//     **/
//    @GetMapping("/selectQualification")
//    ResultData selectQualification();
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 分页查询单位列表
//     **/
//    @PostMapping("/selectAll")
//    ResultData selectAll(@RequestParam("currentPage") Integer currentPage,
//                         @RequestParam("pageSize") Integer pageSize);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 根据单位的userId查询 特殊人员 技术人员 项目数量
//     **/
//    @GetMapping("/selectPersonByuserId")
//    ResultData selectPersonByuserId(@RequestParam Integer userId);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/16
//     * @desc
//     * 查询 人员设备信息
//     **/
//    @GetMapping("/selectUnitPersonEquipment")
//    ResultData selectUnitPersonEquipment(@RequestParam("unitArea") String unitArea);
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 分页模糊查询查询所有单位
//     **/
//    @GetMapping("/selectAllUnitVague")
//    ResultData selectAllUnitVague(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
//            ,@RequestParam("projectName") String unitName);
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     *
//     * 分页模糊查询待修改单位列表
//     **/
//    @GetMapping("/selectUnitNoUpdateAudit")
//    ResultData selectUnitNoUpdateAudit(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
//            ,@RequestParam("projectName") String unitName);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 分页模糊查询待审核单位列表
//     **/
//    @GetMapping("/selectUnitNoRegister")
//    ResultData selectUnitNoRegister(@RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize
//            ,@RequestParam("projectName") String unitName);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据userId查询单位的基本信息
//     **/
//    @PostMapping("/selectUnitByUserId")
//    ResultData selectUnitByUserId(@RequestBody MappingUnit mappingUnit);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 查询关于此单位的附件
//     **/
//    @GetMapping("/selectResourceByUnitId")
//    ResultData selectResourceByUnitId(@RequestParam("userId") Integer userId);
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/18
//     * @desc
//     * 双随机抽查单位
//     **/
//    @PostMapping("/selectUnitRandom")
//    ResultData selectUnitRandom(@RequestParam("currentPage") Integer currentPage,@RequestParam("pageSize") Integer pageSize,
//                                @RequestParam("random") double randmon,@RequestParam("ownedDistrict") String ownedDistrict);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/18
//     * @desc
//     * 根据单位的name level area查询单位
//     **/
//    @GetMapping("/selectUnitBynameAndLevelAndArea")
//    ResultData selectUnitBynameAndLevelAndArea(@RequestParam("unitName") String unitName,@RequestParam("unitLevel") String unitLevel,
//                                               @RequestParam("unitArea") String unitArea);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/18
//     * @desc
//     *  添加一个企业用户
//     **/
//    @PostMapping("/addUnit")
//    ResultData addUnit(@RequestParam Map map);
//
//
//    /**
//     * @author  qlh
//     * @date   2020/7/20
//     * @desc
//     * 修改单位信息
//     **/
//    @PostMapping("/updateUnit")
//    ResultData updateUnit(@RequestBody MappingUnit mappingUnit);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据userId 查询 单位负责人信息
//     **/
//    @PostMapping("/selectOneByUserId")
//    ResultData selectOneByUserId(@RequestParam("userId") Integer userId,@RequestParam("currentPage") Integer currentPage,
//                                 @RequestParam("pageSize") Integer pageSize);
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 根据负责人id查询负责人基本信息和附件
//     **/
//    @GetMapping("/selectPrincipalEnclosure")
//    ResultData selectPrincipalEnclosure(@RequestParam("principalId") Long principalId);
//    /**
//     * @author  qlh
//     * @date   2020/7/20
//     * @desc
//     * 新增一个负责人信息
//     **/
//    @PostMapping("/addPrincipal")
//    ResultData  addPrincipal(@RequestBody Principal principal);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/20
//     * @desc
//     * 修改负责人信息
//     **/
//    @PostMapping("/updatePrincipal")
//    ResultData updatePrincipal(@RequestBody Principal principal);
//    /**
//     * @author  qlh
//     * @date   2020/7/20
//     * @desc
//     * 删除负责人信息
//     **/
//    @PostMapping("/deletePrincipal")
//    ResultData deletePrincipal(@RequestBody Principal principal);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/18
//     * @desc
//     * 根据 成果名称 项目类型  成果日期
//     **/
//    @GetMapping("/selectResultCommitByNmeAndTypeAndDate")
//    ResultData selectResultCommitByNmeAndTypeAndDate(@RequestParam("name") String name, @RequestParam("type") String type,
//                                                     @RequestParam("date") String date);
//
//    /**
//     * @author  qlh
//     * @date   2020/7/17
//     * @desc
//     * 修改单位分值+插入单位分值表
//     **/
//    @PostMapping("/addUnitScore")
//    ResultData addUnitScore(@RequestBody Score score);
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据id查询评分表成功
     **/
    @PostMapping("/selectListScoreByUnitId")
    ResultData selectListScoreByUnitId(@RequestBody Score score, @RequestParam("currentPage") Integer currentPage,
                                       @RequestParam("pageSize") Integer pageSize);
}
