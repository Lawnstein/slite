package com.alipay.slite2.endpoint.exception;

/**
 * CommonException
 * <p/>
 * Created by yangguanchao on 16/11/18.
 */
public class CommonException extends Exception{

    /***
     * 最佳实践:应该是自己定义错误码处理,这里只是示例
     */
    private String errorCode = "CommonError";

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
