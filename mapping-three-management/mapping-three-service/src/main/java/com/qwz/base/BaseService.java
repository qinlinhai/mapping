package com.qwz.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qwz.utils.Map2BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import rx.internal.operators.DeferredScalarSubscriberSafe;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.qwz.staticproperties.OrderStatic.*;

import static com.qwz.staticproperties.OrderStatic.ASC;
import static com.qwz.staticproperties.OrderStatic.DESC;

public abstract class BaseService<T> {
    // 全局变量，缓存子类的泛型类型
    private Class<T> cache = null;

    public Mapper<T> mapper;

     protected Mapper getMapper(){
         return mapper;
     }

    public ResultData insertData(T t){
        int insert = mapper.insert(t);
        if(insert>0){
            ResultData resultData=new ResultData();
            resultData.setData(insert);
        }
        return null;
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 插入数据
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     **/
    public Integer insert(T t){
        return mapper.insert(t);
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 插入数据
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     **/
    public Integer insertSelective(T t){
        return mapper.insertSelective(t);
    }

    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 删除数据
     * 根据主键删除
     **/
    public Integer deleteByPrimaryKey(T t){
        return mapper.deleteByPrimaryKey(t);
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 根据主键批量删除
     **/

    public  Integer deleteByIds(List<Integer> ids){
        Example example=Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id",ids)).build();
        return mapper.deleteByPrimaryKey(example);
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 修改数据
     **/

    public Integer update(T t){
        return mapper.updateByPrimaryKey(t);
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 批量修改数据
     **/
    public Integer updateByIds(T t,Integer [] ids){
        Example example=Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }

    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 查询一条数据
     **/
    public T selectOne(T t){
        return mapper.selectOne(t);
    }

    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 根据条件查询一条数据
     **/
    public T selectOneByFiled(Sqls where,String orderByFiled,String... fields){
        return selectByFileds(null,null,where,orderByFiled,null,fields).get(0);

    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 通过条件查询一个列表
     **/

    public List<T> selectByFiled(Sqls where,String orderByFiled,String orderWord,String...fields){
        return selectByFileds(null,null,where,orderByFiled,orderWord,fields);
    }

    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 通过条件分页查询
     **/

    public PageInfo<T> selectPageInfoByFiled(Integer pageNumber,Integer pageSize,Sqls where,String orderByFiled,String orderWord,String...fields){
        return new PageInfo<>(selectByFileds(pageNumber,pageSize,where,orderByFiled,orderWord,fields));
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     *查询集合 条件查询
     **/
    public List<T> selectList(T t){
        return mapper.select(t);
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     *  查询集合分页查询
     **/

    public PageInfo selectPageList(T t,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> tPageInfo = new PageInfo<>(select);
        return tPageInfo;
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * 实现通用查询
     * 可以排序,分页，多条件查询
     * orderByFiled 需要排序的字段
     *
     **/
    public List<T> selectByFileds(Integer pageNumber,Integer pageSize,Sqls where,String orderByFiled, String orderWord, String... fileds){
        Example.Builder builder=null;
        if(null == fileds || fileds.length==0){
            // 查询所有数据
            builder = Example.builder(getTypeArguement());
        }else {
            // 说明需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }

        if(where != null){
        //说明有自定义where语句
           builder= builder.andWhere(where);
        }
        if(orderByFiled != null){
            //说明需要对某个字段排序
            if(DESC.equals(orderWord)){
                builder=builder.orderByDesc(orderByFiled);
            }else if (ASC.equals(orderWord)){
                builder=builder.orderByAsc(orderByFiled);
            }else{
                builder=builder.orderByDesc(orderByFiled);
            }
        }
        Example example=builder.build();
        //实现分页
        if(pageNumber != null & pageSize != null){
            PageHelper.startPage(pageNumber,pageSize);
        }
        return getMapper().selectByExample(example);
    }

    /**
     * @author Seven Lee
     * @description
     *      获取子类泛型类型
     * @param
     * @date 2020/7/9
     * @return java.lang.Class<T>
     * @throws
     **/
    public Class<T> getTypeArguement() {
        if(null == cache) {
            cache = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }
    /**
     * @author  qlh
     * @date   2020/7/9
     * @desc
     * map 转换为实体类
     **/
    public T newInstance(Map map) {
        return (T) Map2BeanUtils.map2Bean(map, getTypeArguement());
    }
}
