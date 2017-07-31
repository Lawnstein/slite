package com.alipay.APPNAME.endpoint.exception;

/**
 * APPNAMECommonException
 * <p/>
 * Created by yangguanchao on 16/11/18.
 */
public class APPNAMECommonException extends Exception{

    /***
     * 最佳实践:应该是自己定义错误码处理,这里只是示例
     */
    private String errorCode = "CommonError";

    public APPNAMECommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
