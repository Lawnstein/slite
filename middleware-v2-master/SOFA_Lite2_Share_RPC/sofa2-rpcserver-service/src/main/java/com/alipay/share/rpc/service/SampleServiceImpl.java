package com.alipay.share.rpc.service;


import com.alipay.share.rpc.facade.SampleService;

public class SampleServiceImpl implements SampleService {

    @Override
    public String message() {
        return "Hello, Service slitecore";
    }
}
