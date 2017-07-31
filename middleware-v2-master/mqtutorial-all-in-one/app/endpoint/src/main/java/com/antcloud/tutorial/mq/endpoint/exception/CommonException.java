/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.exception;

/**
 * CommonException
 * <p/>
 */
public class CommonException extends Exception {

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
