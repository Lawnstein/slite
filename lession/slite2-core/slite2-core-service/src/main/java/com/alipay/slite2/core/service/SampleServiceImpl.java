package com.alipay.slite2.core.service;


import com.alipay.slite2.core.facade.SampleService;

public class SampleServiceImpl implements SampleService {

    @Override
    public String message() {
        return "Hello, Service slitecore";
    }
}
