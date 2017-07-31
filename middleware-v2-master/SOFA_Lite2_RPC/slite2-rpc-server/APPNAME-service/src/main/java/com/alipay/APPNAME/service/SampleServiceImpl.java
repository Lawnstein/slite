package com.alipay.APPNAME.service;


import com.alipay.APPNAME.facade.SampleService;

public class SampleServiceImpl implements SampleService {

    @Override
    public String message() {
        return "Hello, Service SOFALite2";
    }
}
