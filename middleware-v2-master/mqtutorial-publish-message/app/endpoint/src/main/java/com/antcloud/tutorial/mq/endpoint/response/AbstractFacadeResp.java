/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.response;

/**
 * 通用响应数据封装
 * <p>
 */
public abstract class AbstractFacadeResp {

    /**
     * 成功标志，默认失败。
     */
    private boolean success = false;

    /**
     * 内部错误描述
     */
    private String resultMsg;

    /**
     * 这次操作请求的id
     */
    private String requestId;

    public AbstractFacadeResp(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
