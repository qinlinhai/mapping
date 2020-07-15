package com.qwz.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 **/
@Data
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    /**
     * 状态码
     */

    private String code;
    /**
     * 结果信息
     */
    private String msg;
    private String detail;
    /**
     * 结果数据
     */
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
