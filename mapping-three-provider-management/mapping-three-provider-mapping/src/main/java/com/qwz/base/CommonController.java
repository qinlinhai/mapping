package com.qwz.base;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class CommonController<T> extends BaseController{

    public abstract  BaseService<T> getBaseService();

    public ResultData add(Map map) {
        return new ResultData();
    }


    @Override
    public ResultData loginSuccess(){
       return super.loginSuccess();
    }


    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 新增一条数据
     **/
    public ResultData insert(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        Integer integer = getBaseService().insertSelective(t);
        if(integer>0){
            return super.addSuccess();
        }else{
            return super.addFailed();
        }

    }

    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 删除一条数据
     **/
    public ResultData deleteOne(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        Integer integer = getBaseService().deleteByPrimaryKey(t);
        if(integer>0){
            return super.deleteSuccess();
        }else{
            return super.deleteFailed();
        }
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 批量删除数据
     **/

    public ResultData deleteByIds(@RequestBody String ids){
        String[] split = ids.split(",");
        Integer [] idss = new Integer[split.length];
        for (int i=0;i<split.length;i++){
            idss[i]=Integer.parseInt(split[i]);
        }
        Integer integer = getBaseService().deleteByIds(Arrays.asList(idss));
        if(integer>0){
            return super.deleteSuccess("批量删除成功");
        }else{
            return super.deleteFailed("批量删除失败");
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 修改数据
     **/

    public ResultData updateOne(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        Integer update = getBaseService().update(t);
        if(update>0){
            return super.updateSuccess();
        }else{
            return super.updateFailed();
        }
    }

    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 无条件查询一条数据
     **/

    public  ResultData selectOne(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        T t1 = getBaseService().selectOne(t);
        if(t1!=null){
            return super.selectSuccess();
        }else{
            return super.selectFailed();
        }
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 查询集合
     **/
    public ResultData selectList(@RequestBody Map map){
        T t = getBaseService().newInstance(map);
        List<T> ts = getBaseService().selectList(t);
        if(ts!=null && ts.size()>0){
            return super.selectSuccess();
        }else{
            return super.selectFailed();
        }
    }


}
