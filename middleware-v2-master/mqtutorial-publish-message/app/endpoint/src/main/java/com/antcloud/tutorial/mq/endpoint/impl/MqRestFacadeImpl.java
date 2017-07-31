/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.antcloud.tutorial.mq.endpoint.exception.CommonException;
import com.antcloud.tutorial.mq.endpoint.facade.MqRestFacade;
import com.antcloud.tutorial.mq.endpoint.response.RestSampleFacadeResp;
import com.antcloud.tutorial.mq.endpoint.service.MqService;

public class MqRestFacadeImpl implements MqRestFacade {

    private static final Logger logger = LoggerFactory.getLogger(MqRestFacadeImpl.class);

    private MqService           mqService;

    @Override
    public RestSampleFacadeResp<String> publish() throws CommonException {
        if (logger.isInfoEnabled()) {
            logger.info("Receive a message publish request.");
        }

        boolean success = mqService.publish();

        RestSampleFacadeResp<String> result = new RestSampleFacadeResp<>();
        String responseMsg = "Publish a message, " + (success ? "success" : "failure") + ".";
        result.setData(String.valueOf(responseMsg));
        result.setSuccess(Boolean.valueOf(success));

        return result;
    }

    public void setMqService(MqService mqService) {
        this.mqService = mqService;
    }
}
