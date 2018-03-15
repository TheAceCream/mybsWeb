package com.mybs.exception;

/**
 * Created by AceCream on 2018/3/13.
 */
public enum APICode {

    OK(Integer.valueOf(0),"success"),
    RUNTIME_EXECEPTION(1,"系统异常!"),
    PARAM_INVALID(2,"参数异常!"),
    UNKNOW_EXECEPTION(3,"未知异常"),

    //登录注册方面
    LOGIN_FAILED(100,"用户名或密码有误!"),
    USER_ADD_FAILED(101,"用户名已存在!");



    private int code;
    private String msg;

    APICode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static APICode getByCode(Integer code){
        if (code == null){
            return null;
        }
        for (APICode apiCode : APICode.values()) {
            return apiCode;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("[code:&s,message:%s]",new Object[]{Integer.valueOf(this.code),this.msg});
    }

}
