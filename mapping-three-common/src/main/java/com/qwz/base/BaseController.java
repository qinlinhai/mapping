package com.qwz.base;
import javax.xml.transform.Result;

import static com.qwz.status.LoginStatus.*;
import static com.qwz.status.AddStatus.*;
import static com.qwz.status.DeleteStatus.*;
import static com.qwz.status.UpdateStatus.*;
import static com.qwz.status.SelectStatus.*;
import static com.qwz.status.ZuulStatus.*;
import static com.qwz.status.FileStatus.*;

/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 *     统一controller
 *        也就是说所有的controller都需要继承这个controller，进行统一返回
 *
 *  eg: 6
 *  登录成功和失败
 *  code:200 msg:登录成功
 *  code:400 msg:登录失败，系统异常
 *  code:201 msg:用户已经存在
 *  code:401 msg:用户不存在
 *  code:402 msg:密码错误
 *  code:405 msg:用户退出异常
 **/
public class BaseController {


/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆成功 使用系统消息
 **/

public ResultData loginSuccess(){
    ResultData resultData = new ResultData();
    resultData.setCode(LOGIN_SUCCESS.getCode());
    resultData.setMsg(LOGIN_SUCCESS.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆成功 使用自定义返回消息
 **/
public ResultData loginSuccess(String msg){
    ResultData resultData=new ResultData();
    resultData.setCode(LOGIN_SUCCESS.getCode());
    resultData.setMsg(msg);
    return resultData;
}

/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆成功 返回数据信息
 *
 **/
public ResultData loginSuccess(Object data){
    ResultData resultData=new ResultData();
    resultData.setCode(LOGIN_SUCCESS.getCode());
    resultData.setMsg(LOGIN_SUCCESS.getMsg());
    resultData.setData(data);
    return resultData;
}

/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆成功  返回数据 自定义信息
 **/
public ResultData loginSuccess(String msg,Object data){
    ResultData resultData=new ResultData();
    resultData.setCode(LOGIN_SUCCESS.getCode());
    resultData.setMsg(msg);
    resultData.setData(data);
    return resultData;
}


/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆失败 返回系统消息
 **/
public ResultData loginFailed(){
    ResultData resultData=new ResultData();
    resultData.setCode(LOGIN_FAILED.getCode());
    resultData.setMsg(LOGIN_FAILED.getMsg());
    return resultData;
}

/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆失败 返回详细信息
 **/
public ResultData loginFailed(String detail){
    ResultData resultData=new ResultData();
    resultData.setCode(LOGIN_FAILED.getCode());
    resultData.setDetail(detail);
    return resultData;
}

/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 注册失败返回用户名已存在
 **/
public ResultData userExit(){
    ResultData resultData=new ResultData();
    resultData.setCode(USER_EXIST.getCode());
    resultData.setMsg(USER_EXIST.getMsg());
    return resultData;
}

/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆失败 用不存在
 **/
public ResultData userNoExit(){
    ResultData resultData=new ResultData();
    resultData.setCode(USER_NOT_EXIST.getCode());
    resultData.setMsg(USER_NOT_EXIST.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 * 登陆失败 密码错误
 **/
public ResultData passwordWaring(){
    ResultData resultData=new ResultData();
    resultData.setCode(PASSWORD_WRONG.getCode());
    resultData.setMsg(PASSWORD_WRONG.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 增加成功
 * 返回系统消息
 **/
public ResultData addSuccess(){
    ResultData resultData=new ResultData();
    resultData.setCode(ADD_SUCCESS.getCode());
    resultData.setMsg(ADD_SUCCESS.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 增加成功返回自定义消息
 **/
public ResultData addSuccess(String msg){
    ResultData resultData=new ResultData();
    resultData.setCode(ADD_SUCCESS.getCode());
    resultData.setMsg(msg);
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 增加失败
 * 返回系统消息
 **/
public ResultData addFailed(){
    ResultData resultData=new ResultData();
    resultData.setCode(ADD_FAILED.getCode());
    resultData.setMsg(ADD_FAILED.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 增加失败
 * 返回自定义消息
 **/
public ResultData addFailed(String msg){
    ResultData resultData=new ResultData();
    resultData.setCode(ADD_FAILED.getCode());
    resultData.setMsg(msg);
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 增加失败
 * 新增数据已经存在
 * 返回系统消息
 *
 **/
public ResultData addFailedDataExist(){
    ResultData resultData=new ResultData();
    resultData.setCode(ADD_DATA_EXIST.getCode());
    resultData.setMsg(ADD_DATA_EXIST.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 新增数据已经存在返回自定义结果集
 **/
public ResultData addFailedDataExist(String msg){
    ResultData resultData=new ResultData();
    resultData.setCode(ADD_DATA_EXIST.getCode());
    resultData.setMsg(msg);
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 删除成功
 * 返回系统消息
 **/
public ResultData deleteSuccess(){
    ResultData resultData=new ResultData();
    resultData.setCode(DELETE_SUCCESS.getCode());
    resultData.setMsg(DELETE_SUCCESS.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 删除成功
 * 返回自定义消息
 **/
public ResultData deleteSuccess(String msg){
    ResultData resultData=new ResultData();
    resultData.setCode(DELETE_SUCCESS.getCode());
    resultData.setMsg(msg);
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 删除失败
 * 返回系统消息
 **/
public ResultData deleteFailed(){
    ResultData resultData=new ResultData();
    resultData.setCode(DELETE_FAILED.getCode());
    resultData.setMsg(DELETE_FAILED.getMsg());
    return  resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 删除失败
 * 返回自定义消息
 **/
public ResultData deleteFailed(String msg){
    ResultData resultData=new ResultData();
    resultData.setCode(DELETE_FAILED.getCode());
    resultData.setMsg(msg);
    return resultData;
}

/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 删除数据不存在
 * 返回系统消息
 **/
public  ResultData deleteDataNoExist(){
    ResultData resultData=new ResultData();
    resultData.setCode(DELETE_DATA_NO_EXIST.getCode());
    resultData.setMsg(DELETE_DATA_NO_EXIST.getMsg());
    return resultData;
}
/**
 * @author  qlh
 * @date   2020/7/9
 * @desc
 * 删除数据不存在
 * 返回自定义消息
 **/
public ResultData deleteDataNoExist(String msg){
    ResultData resultData=new ResultData();
    resultData.setCode(DELETE_DATA_NO_EXIST.getCode());
    resultData.setMsg(msg);
    return resultData;
}

    /**
     * @Description: 路由过滤成功
     * @Author: Bing
     * @Date: 2020/7/9 15:31
     **/
    protected ResultData operationZuulSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_SUCCESS.getMsg());
        return  resultData;
    }

    /**
     * @Description: 路由过滤成功,返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:31
     **/
    protected ResultData operationZuulSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_SUCCESS.getCode());
        resultData.setMsg(msg);
        return  resultData;
    }

    /**
     * @Description: 路由过滤失败
     * @Author: Bing
     * @Date: 2020/7/9 15:32
     **/
    protected ResultData operationZuulFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 路由过滤失败，返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:32
     **/
    protected ResultData operationZuulFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: token值存在
     * @Author: Bing
     * @Date: 2020/7/9 15:34
     **/
    protected ResultData operationZuulTokenSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: token值存在,返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:34
     **/
    protected ResultData operationZuulTokenSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: token值不存在
     * @Author: Bing
     * @Date: 2020/7/9 15:35
     **/
    protected ResultData operationZuulTokenFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(ZUUL_FILTER_TOKEN_FAILED.getMsg());
        return  resultData;
    }

    /**
     * @Description: token值不存在，返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:35
     **/
    protected ResultData operationZuulTokenFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ZUUL_FILTER_TOKEN_FAILED.getCode());
        resultData.setMsg(msg);
        return  resultData;
    }

    /**
     * @Description: 修改成功
     * @Author: Bing
     * @Date: 2020/7/9 15:46
     **/
    protected ResultData updateSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(UPDATE_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 修改成功，返回自定义信息
     * @Author: Bing
     * @Date: 2020/7/9 15:46
     **/
    protected ResultData updateSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 修改失败
     * @Author: Bing
     * @Date: 2020/7/9 15:46
     **/
    protected ResultData updateFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(UPDATE_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 修改失败，返回自定义信息
     * @Author: Bing
     * @Date: 2020/7/9 15:46
     **/
    protected ResultData updateFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 修改数据不存在
     * @Author: Bing
     * @Date: 2020/7/9 15:46
     **/
    protected ResultData updateNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_NO_EXIST.getCode());
        resultData.setMsg(UPDATE_DATA_NO_EXIST.getMsg());
        return resultData;
    }

    /**
     * @Description: 修改数据不存在，返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:46
     **/
    protected ResultData updateNotExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_DATA_NO_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 文件上传成功
     * @Author: Bing
     * @Date: 2020/7/9 15:50
     **/
    protected ResultData fileSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(FILE_UPLOAD_SUCCESS.getCode());
        resultData.setMsg(FILE_UPLOAD_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 文件上传成功，返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:50
     **/
    protected ResultData fileSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(FILE_UPLOAD_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 文件上传失败
     * @Author: Bing
     * @Date: 2020/7/9 15:50
     **/
    protected ResultData fileFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(FILE_UPLOAD_FAILED.getCode());
        resultData.setMsg(FILE_UPLOAD_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 文件上传失败，返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:50
     **/
    protected ResultData fileFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(FILE_UPLOAD_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 查询成功
     * @Author: Bing
     * @Date: 2020/7/9 15:54
     **/
    protected ResultData selectSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(SELECT_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @Description: 查询成功，返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:54
     **/
    protected ResultData selectSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 查询失败
     * @Author: Bing
     * @Date: 2020/7/9 15:54
     **/
    protected ResultData selectFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(SELECT_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Description: 查询失败，返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:54
     **/
    protected ResultData selectFailed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Description: 查询数据不存在
     * @Author: Bing
     * @Date: 2020/7/9 15:54
     **/
    protected ResultData selectNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_NO_EXIST.getCode());
        resultData.setMsg(SELECT_DATA_NO_EXIST.getMsg());
        return resultData;
    }

    /**
     * @Description: 查询数据不存在,返回自定义消息
     * @Author: Bing
     * @Date: 2020/7/9 15:54
     **/
    protected ResultData selectNotExist(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_DATA_NO_EXIST.getCode());
        resultData.setMsg(msg);
        return resultData;
    }




}
