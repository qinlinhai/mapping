package com.qwz.status;

public enum AddStatus {
    ADD_SUCCESS("2001","新增成功"),
    ADD_FAILED("2002","新增失败"),
    ADD_DATA_EXIST("2003","新增数据已存在");

    AddStatus(String code, String msg) {
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
