package com.harmonycloud.result;

import java.io.Serializable;

/**
 * @author qidong
 * @date 2019/2/15
 */
public class CimsResponseWrapper implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object errorMessage;
    private Boolean success;
    private Object data;

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }


    public CimsResponseWrapper(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
    public CimsResponseWrapper(Boolean success, Object data, Object errorMessage) {
        this.success = success;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public CimsResponseWrapper() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public static CimsResponseWrapper buildSuccess(Object data){
        return new CimsResponseWrapper(true, data);
    }


}
