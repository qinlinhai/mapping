package com.qwz.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.MappingProjectMapper;
import com.qwz.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MappingProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    public PageInfo selectSuccessRegister(Integer currentPage,Integer pageSize,String searchName) throws Exception {
        PageHelper.startPage(currentPage,pageSize);
        List<MappingProject> mappingProjects = mappingProjectMapper.selectSuccessRegister(searchName);
        PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<>(mappingProjects);
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
        PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<>(mappingProjects);
        return mappingProjectPageInfo;
    }

    public PageInfo selectNoRemittance(Integer currentPage,Integer pageSize,String projectName){
        PageHelper.startPage(currentPage,pageSize);
        List<MappingProject> mappingProjects = mappingProjectMapper.selectNoRemittance(projectName);
        PageInfo<MappingProject> mappingProjectPageInfo = new PageInfo<>(mappingProjects);
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
        List<Map> result=new ArrayList<>();
        Map<Object, Object> map1 = new HashMap<>();
        Map<Object, Object> map2 = new HashMap<>();
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
}
