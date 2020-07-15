package com.qwz.status;

public enum  SelectStatus {
    SELECT_SUCCESS("1001","查询成功"),
    SELECT_FAILED("1002","查询失败"),
    SELECT_DATA_NO_EXIST("1003","查询数据不存在"),
    ;

    SelectStatus(String code, String msg) {
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
