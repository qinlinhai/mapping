package com.qwz.service;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.mapper.PrincipalMapper;
import com.qwz.mapper.ResourceMapper;
import com.qwz.model.Principal;
import com.qwz.model.Resource;
import com.qwz.properties.FtpProperties;
import com.qwz.utils.DateUtils;
import com.qwz.utils.FilenameUtils;
import com.qwz.utils.FtpUtils;
import com.qwz.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import static com.qwz.staticproperties.RedisProperties.POINT;
import static com.qwz.staticproperties.TimeForatProperties.DATE_FORMAT;

@Service
public class PrincipalService extends BaseService<Principal> {

    @Autowired
    private PrincipalMapper principalMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private FtpProperties ftp;
    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据id查询负责人信息
     **/
    public PageInfo selectOneByUserId(Integer userId,Integer currentPage,Integer pageSize){
       if(currentPage!=null && !"".equals(currentPage) && pageSize!=null && !"".equals(pageSize)){
           PageHelper.startPage(currentPage,pageSize);
           if(userId!=null && !"".equals(userId)){
               List<Principal> principals = principalMapper.selectPrincipal(userId);
               PageInfo<Principal> principalPageInfo = new PageInfo<Principal>(principals);
               if(principalPageInfo!=null){
                   return principalPageInfo;
               }else{
                   return null;
               }
           }
       }
        return null;
    }

    /**
     * @author  qlh
     * @date   2020/7/17
     * @desc
     * 根据负责人id查询负责新详细信息以及附件
     **/
    public List<Map> selectPrincipalEnclosure(Long principal){
        if (principal!=null && !"".equals(principal)){
            List<Map> maps = principalMapper.selectPrincipalEnclosure(principal);
            if(maps!=null && maps.size()>0){
                return maps;
            }
        }
        return null;
    }
    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 新增一条单位负责人信息
     **/
    public Boolean addPrincipal(Principal principal){
        if(principal!=null){
            Integer insert = super.insert(principal);
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
     * @date   2020/7/20
     * @desc
     * 修改单位负责人信息
     **/
    public Boolean updatePrincipal(Principal principal){
        if(principal!=null){
            Integer update = super.update(principal);
            if(update>0){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * @author  qlh
     * @date   2020/7/20
     * @desc
     * 删除单位负责人
     **/
    public  Boolean deletePrincipal(Principal principal){
        if(principal!=null){
            Integer integer = super.deleteByPrimaryKey(principal);
            if(integer>0){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * @author  qlh
     * @date   2020/7/22
     * @desc
     * 负责人文件上传
     **/
    public Boolean PrincipalUploadService(MultipartFile [] manyfile,String refBizType,Long refBizId,String memo){
        for (MultipartFile file:manyfile
             ) {
            String oldname = file.getOriginalFilename();
            long size = file.getSize();
            String extName = oldname.substring(oldname.indexOf(POINT), oldname.length());
            Resource resource=new Resource();
            String newfileName=FilenameUtils.getFileName();
            String filePath= DateUtils.Date2StringByType(DateUtils.getCurrentDate(),DATE_FORMAT);
            String path=ftp.getHttpPath()+"/"+filePath+"/"+newfileName;
            resource.setId(Long.valueOf(IDUtils.getNum18()));
            resource.setPath(path);
            resource.setExtName(extName);
            resource.setMemo(memo);
            resource.setName(oldname);
            resource.setSize(size);
            resource.setRefBizId(refBizId);
            resource.setRefBizType(refBizType);
            resourceMapper.insert(resource);
            try {
                return FtpUtils.upload(ftp.getHost(),ftp.getPort(),ftp.getUsername(),ftp.getPassword(),ftp.getBasePath(),filePath,newfileName,file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }


}
