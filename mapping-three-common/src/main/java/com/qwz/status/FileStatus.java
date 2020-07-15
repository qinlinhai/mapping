package com.qwz.status;

public enum FileStatus {
    FILE_UPLOAD_SUCCESS("6001","文件上传成功"),
    FILE_UPLOAD_FAILED("6002","文件上传失败");


    FileStatus(String code, String msg) {
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
