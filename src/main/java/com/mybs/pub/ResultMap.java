package com.mybs.pub;

import com.mybs.exception.APICode;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by AceCream on 2018/3/13.
 */
public class ResultMap implements Serializable{

    private static final long serialVerionUID = -8922211823978L;

    private Integer errCode;
    private String errMsg;
    private Object data;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultMap() {
    }

    public ResultMap(Integer errCode, String errMsg, Object data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public ResultMap(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = new HashMap<>();
    }

    public ResultMap(APICode apiCode) {
        this.errCode = apiCode.getCode();
        this.errMsg = apiCode.getMsg();
    }

    public ResultMap(APICode apiCode, Object obj) {
        this.errCode = apiCode.getCode();
        this.errMsg = apiCode.getMsg();
        this.data = obj;
    }

    public void setApiCode(APICode apiCode){
        this.errCode = apiCode.getCode();
        this.errMsg = apiCode.getMsg();
    }

}
