package com.harmonycloud.result;

/**
 * @author qidong
 * @date 2019/2/15
 */
public class ErrorMsgConstant {
    private String msg;

    public ErrorMsgConstant(String msg) {
        this.msg = msg;
    }
    public static String QUERY_DATA_ERROR = "query data error";



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
