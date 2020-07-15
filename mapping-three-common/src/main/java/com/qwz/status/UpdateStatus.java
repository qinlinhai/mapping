package com.qwz.status;

public enum UpdateStatus {
    UPDATE_SUCCESS("4001","修改成功"),
    UPDATE_FAILED("4002","修改失败"),
    UPDATE_DATA_NO_EXIST("4003","修改数据不存在");


    UpdateStatus(String code, String msg) {
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
