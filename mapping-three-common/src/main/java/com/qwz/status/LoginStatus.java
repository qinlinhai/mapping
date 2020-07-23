package com.qwz.status;
/**
 * @author  qlh
 * @date   2020/7/8
 * @desc
 **/
public enum LoginStatus {
    LOGIN_SUCCESS("7001", "登录成功"),
    LOGIN_FAILED("7002", "登录失败，系统异常"),
    USER_EXIST("7003", "用户已经存在"),
    USER_NOT_EXIST("7004", "用户不存在"),
    PASSWORD_WRONG("7005", "密码错误"),
    LOGOUT_WRONG("7006", "用户退出异常"),
    SYSTEM_EXCEPTION("7007", "系统异常");

    LoginStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

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
}
