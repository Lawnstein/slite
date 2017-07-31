/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.antcloud.tutorial.mq.endpoint.exception.CommonException;
import com.antcloud.tutorial.mq.endpoint.facade.MqRestFacade;
import com.antcloud.tutorial.mq.endpoint.model.MqMessage;
import com.antcloud.tutorial.mq.endpoint.response.RestSampleFacadeResp;
import com.antcloud.tutorial.mq.endpoint.service.Account;
import com.antcloud.tutorial.mq.endpoint.service.MqMessageRepository;
import com.antcloud.tutorial.mq.endpoint.service.MqService;

public class MqRestFacadeImpl implements MqRestFacade {

    private static final Logger logger    = LoggerFactory.getLogger(MqRestFacadeImpl.class);

    private final static String TOPIC     = "TP_DEFAULT";

    private final static String EVENTCODE = "EC_DEFAULT";

    private MqService           mqService;

    @Override
    public RestSampleFacadeResp<MqMessage> publish() throws CommonException {
        if (logger.isInfoEnabled()) {
            logger.info("Receive a message publish request.");
        }

        Object payload = Account.buildDefaultInstance();
        boolean success = mqService.publish(TOPIC, EVENTCODE, payload);

        RestSampleFacadeResp<MqMessage> result = new RestSampleFacadeResp<>();
        MqMessage mqMessage = new MqMessage(TOPIC, EVENTCODE, payload);

        result.setData(mqMessage);
        result.setSuccess(Boolean.valueOf(success));
        return result;
    }

    @Override
    public RestSampleFacadeResp<List<MqMessage>> subscribe() throws Exception {
        if (logger.isInfoEnabled()) {
            logger.info("Receive a message subscribe request.");
        }

        RestSampleFacadeResp<List<MqMessage>> result = new RestSampleFacadeResp<>();
        result.setData(MqMessageRepository.getInstance().queryAll());
        result.setSuccess(true);
        return result;
    }

    public void setMqService(MqService mqService) {
        this.mqService = mqService;
    }
}
