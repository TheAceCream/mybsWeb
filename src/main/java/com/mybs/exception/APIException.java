package com.mybs.exception;

import java.io.Serializable;

/**
 * Created by AceCream on 2018/3/13.
 */
public class APIException extends RuntimeException implements Serializable {

    public int code;
    public String msg;

    public APIException(String msg){super(msg);}

    private APIException(int code,String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public APIException(APICode apiCode){
        this(apiCode.getCode(),apiCode.getMsg());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setAPICode(APICode apiCode){
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
    }

}
