/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.response;

/**
 * 响应数据封装,将实际返回的数据封装成json,最后会返回 json 数据
 * <p/>
 */
public class RestSampleFacadeResp<T> extends AbstractFacadeResp {

    /**
     * response的返回对象数据
     */
    private T data;


    public RestSampleFacadeResp() {
        super(true);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestSampleFacadeResp{" +
                "data=" + data +
                '}';
    }
}
