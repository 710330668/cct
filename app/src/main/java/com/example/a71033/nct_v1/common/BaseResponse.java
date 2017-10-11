package com.example.a71033.nct_v1.common;

import java.io.Serializable;

/**
 * Created by 71033 on 2017/10/11.
 */

public class BaseResponse implements Serializable {

    private String retCode;
    private String retInfo;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetInfo() {
        return retInfo;
    }

    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "retCode='" + retCode + '\'' +
                ", retInfo='" + retInfo + '\'' +
                '}';
    }
}
