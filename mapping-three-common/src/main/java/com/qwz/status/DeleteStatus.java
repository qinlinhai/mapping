package com.qwz.status;

public enum DeleteStatus {
    DELETE_SUCCESS("3001","删除成功"),
    DELETE_FAILED("3002","删除失败"),
    DELETE_DATA_NO_EXIST("3003","删除的数据不存在");

    DeleteStatus(String code, String msg) {
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
