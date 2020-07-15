package com.qwz.status;

public enum ZuulStatus {
    ZUUL_FILTER_SUCCESS("5001", "路由过滤成功"),
    ZUUL_FILTER_FAILED("5002", "路由过滤失败"),
    ZUUL_FILTER_TOKEN_SUCCESS("5003", "token值存在"),
    ZUUL_FILTER_TOKEN_FAILED("5004", "token值不存在");


    ZuulStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;


    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
