package com.mybs.pub;

import com.mybs.exception.APICode;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by AceCream on 2018/3/13.
 */
public class BaseResultMap implements Serializable{

    private Integer code;
    private String msg;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseResultMap() {
    }

    public BaseResultMap(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public BaseResultMap(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = new HashMap<>();
    }

    public BaseResultMap(APICode apiCode){
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
    }

    public BaseResultMap(APICode apiCode,Object obj){
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
        this.data = obj;
    }

    public void setAPICode(APICode apiCode){
        this.code = apiCode.getCode();
        this.msg = apiCode.getMsg();
    }


}
