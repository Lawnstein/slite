package com.antcloud.tutorial.scheduler.service;


import com.antcloud.tutorial.scheduler.facade.SampleService;

public class SampleServiceImpl implements SampleService {

    @Override
    public String message() {
        return "Hello, Service slitecore";
    }
}
