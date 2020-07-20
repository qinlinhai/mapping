package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.MappingProjectMapper;
import com.qwz.mapper.ResourceMapper;
import com.qwz.mapper.ResultCommitMapper;
import com.qwz.model.MappingProject;
import com.qwz.model.Resource;
import com.qwz.model.ResultCommit;
import com.qwz.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MappingProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ResultCommitMapper resultCommitMapper;

    public PageInfo selectSuccessRegister(Integer currentPage,Integer pageSize,String searchName) throws Exception {
        PageHelper.startPage(currentPage,pageSize);
        List<MappingProject> mappingProjects = mappingProjectMapper.selectSuccessRegister(searchName);
        PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<MappingProject>(mappingProjects);
        return mappingProjectPageInfo;
    }



    public PageInfo selectSuccessRemittance(Integer currentPage,Integer pageSize,String searchName){
        PageHelper.startPage(currentPage,pageSize);
        List<MappingProject> mappingProjects = mappingProjectMapper.selectSuccessRemittance(searchName);
        PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<MappingProject>(mappingProjects);
        return mappingProjectPageInfo;
    }

    public MappingProject selectSuccessRegisterById(Long projectId){
        MappingProject mappingProject = mappingProjectMapper.selectSuccessRegisterById(projectId);
        if(mappingProject != null && !"".equals(mappingProject)){
            return mappingProject;
        }
        return null;
    }

    public List<Map> selectProjectandResource(Long projectId){
        List<Map> maps = mappingProjectMapper.selectProjectandResource(projectId);
        if(maps !=null && !"".equals(maps)){
            return maps;
        }
        return null;
    }

    public PageInfo selectNoAudit(Integer currentPage,Integer pageSize,String projectName){
      PageHelper.startPage(currentPage,pageSize);
        List<MappingProject> mappingProjects = mappingProjectMapper.selectNoAudit(projectName);
        PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<MappingProject>(mappingProjects);
        return mappingProjectPageInfo;
    }

    public PageInfo selectNoRemittance(Integer currentPage,Integer pageSize,String projectName){
        PageHelper.startPage(currentPage,pageSize);
        List<MappingProject> mappingProjects = mappingProjectMapper.selectNoRemittance(projectName);
        PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<MappingProject>(mappingProjects);
        return mappingProjectPageInfo;
    }


    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     * 给项目审核通过
     **/
    public Boolean updateMappingProjectAuditStatus(MappingProject mappingProject){
        if(mappingProject!= null && !"".equals(mappingProject)){
            Integer update = super.update(mappingProject);
            if(update>0){
                return true;
            }
        }
        return false;
    }


    /**
     * @author  qlh
     * @date   2020/7/16
     * @desc
     *
     * 查询 已完成 和未完成的 项目类型
     **/
    public List<Map> selectPRojectByType(){
        List<Map> successmaps = mappingProjectMapper.selectSuccess();
        List<Map> failedmaps= mappingProjectMapper.selectFailed();
        List<Map> result=new ArrayList<Map>();
        Map<Object, Object> map1 = new HashMap<Object, Object>();
        Map<Object, Object> map2 = new HashMap<Object, Object>();
        if(successmaps!= null && successmaps.size()>0){
            map1.put("success",successmaps);
        }
        if(failedmaps!=null && failedmaps.size()>0){
            map2.put("failed",failedmaps);
        }
        result.add(map1);
        result.add(map2);
        return result;
    }

    /**
     * @Description: 项目管理  查询登录用户管理的项目
     * @Author: Bing
     * @Date: 2020/7/16 21:42
     **/
    public PageInfo selectAdm(String projectType,Integer userid,Integer pageNumber,Integer pageSize){
        //传入当前页和数量
        PageHelper.startPage(pageNumber,pageSize);
        try {
            //调用查询方法
            List<MappingProject> mappingProjects = mappingProjectMapper.selectAdm(projectType,userid);
            //判断查询数据是否为空
            if (mappingProjects != null && !"".equals(mappingProjects)){
                //对查询出的数据进行分页
                PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<MappingProject>(mappingProjects);
                if (mappingProjectPageInfo != null && !"".equals(mappingProjectPageInfo)){
                    return mappingProjectPageInfo;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 项目管理  添加项目
     * @Author: Bing
     * @Date: 2020/7/17 9:04
     **/
    public Boolean insertAdm(MappingProject mappingProject,Map map){
        String path1 = map.get("path1").toString();
        //自动生成id
        mappingProject.setId(Long.valueOf(IDUtils.getNum18()));
        if (mappingProject != null && !"".equals(mappingProject)){
            try {
                //调用通用Mapper的添加方法
                int insert = mappingProjectMapper.insert(mappingProject);
                if (insert > 0){
                    ResultCommit resultCommit = new ResultCommit();
                    resultCommit.setId(Long.valueOf(IDUtils.getNum18()));
                    resultCommit.setHeightDatum(Integer.parseInt(map.get("height_datum").toString()));
                    resultCommit.setRefId(mappingProject.getId());
                    int insert1 = resultCommitMapper.insert(resultCommit);
                    if (insert1 > 0){
                        Resource resource = new Resource();
                        resource.setId(Long.valueOf(IDUtils.getNum18()));
                        resource.setPath(path1);
                        resource.setRefBizId(mappingProject.getId());
                        resource.setCreateTime(new Date());
                        resource.setExtName(path1.substring(path1.indexOf("."),path1.length()));
                        int insert2 = resourceMapper.insert(resource);
                       if (insert2 > 0){
                           return true;
                       }else {
                           return false;
                       }
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @Description: 项目管理  修改项目
     * @Author: Bing
     * @Date: 2020/7/17 10:38
     **/
    public Integer updateAdm(MappingProject mappingProject){
        if (mappingProject != null && !"".equals(mappingProject)){
            try {
                int updateByPrimaryKey = mappingProjectMapper.updateByPrimaryKey(mappingProject);
                //判断是否添加成功
                if (updateByPrimaryKey > 0){
                    return updateByPrimaryKey;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }

    /**
     * @Description: 项目管理  删除项目
     * @Author: Bing
     * @Date: 2020/7/17 10:42
     **/
    public Integer delectAdm(Long id){
        //判断前端传值是否成功
        if(id != null && !"".equals(id)){
            try {
                //根据id删除项目
                int i = mappingProjectMapper.deleteByPrimaryKey(id);
                if (i > 0){
                    return i;
                }else {
                    return -1;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }

    /**
     * @Description: 项目汇交
     * @Author: Bing
     * @Date: 2020/7/17 11:04
     **/
    public PageInfo selectRem(String projectType,Integer userid,Integer pageNumber,Integer pageSize){
        //传入当前页和数量
        PageHelper.startPage(pageNumber,pageSize);
        try {
            //调用查询方法
            List<MappingProject> mappingProjects = mappingProjectMapper.selectRem(projectType,userid);
            //判断查询数据是否为空
            if (mappingProjects != null && !"".equals(mappingProjects)){
                //对查询出的数据进行分页
                PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<MappingProject>(mappingProjects);
                if (mappingProjectPageInfo != null && !"".equals(mappingProjectPageInfo)){
                    return mappingProjectPageInfo;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: 项目汇交  修改汇交信息
     * @Author: Bing
     * @Date: 2020/7/17 11:06
     **/
    public Integer updateRem(MappingProject mappingProject){
        //判断是否获取到值
        if (!"".equals(mappingProject) && mappingProject != null){
            try {
                //调用通用Mapper的修改方法
                int update = mappingProjectMapper.updateByPrimaryKey(mappingProject);
                //判断是否修改成功
                if (update > 0){
                    return update;
                }
                return -1;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return -1;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据userId查询单位所属项目
     **/
    public PageInfo selectProjectByUserId(Integer currentPage,Integer pageSize,Integer userId){
        if(currentPage!=null && pageSize!=null){
            PageHelper.startPage(currentPage,pageSize);
            if(userId!=null){
                List<MappingProject> mappingProjects = mappingProjectMapper.selectProjectByUserId(userId);
                if(mappingProjects!=null&&mappingProjects.size()>0){
                    PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<MappingProject>(mappingProjects);
                    return mappingProjectPageInfo;
                }else{
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * @Description: 首页测绘项目查询
     * @Author: Bing
     * @Date: 2020/7/18 15:04
     **/
    public List<MappingProject> selectShow(String projectType, String projectName, String startDate){
        List<MappingProject> mappingProjects = mappingProjectMapper.selectShow(projectType, projectName, startDate);
        return mappingProjects;
    }
}
