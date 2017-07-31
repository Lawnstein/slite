/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventBuilder;
import com.alipay.common.event.UniformEventPublisher;
import com.alipay.common.event.impl.DefaultUniformEventBuilder;

/**
 * MqService publishes a message to the message queue broker.
 *
 */
public class MqService {

    private static final Logger   logger              = LoggerFactory.getLogger(MqService.class);

    private final static String   TOPIC               = "TP_DEFAULT";

    private final static String   EVENTCODE           = "EC_DEFAULT";

    private UniformEventPublisher mqPublisher;

    private UniformEventBuilder   uniformEventBuilder = new DefaultUniformEventBuilder();

    public boolean publish() {
        if (logger.isInfoEnabled()) {
            logger.info("Publish a message.");
        }

        /* Create a message instance. */
        final UniformEvent message = uniformEventBuilder.buildUniformEvent(TOPIC, EVENTCODE);

        /* Set the business object as an event payload. */
        message.setEventPayload(buildDefaultAccount());

        /* Mark that a runtime exception must be thrown when publishing failure. */
        message.setThrowExceptionOnFailed(true);

        boolean publishSuccess = false;

        try {
            /* Do publish action. */
            mqPublisher.publishUniformEvent(message);
            publishSuccess = true;

            logger.info("Public a message, success. TOPIC [{}] EVENTCODE [{}] id [{}] payload [{}]", new Object[] {
                    message.getTopic(), message.getEventCode(), message.getId(), message.getEventPayload() });
        } catch (Exception e) {
            logger.error("Public a message, failure. TOPIC [{}] EVENTCODE [{}] error [{}]",
                new Object[] { message.getTopic(), message.getEventCode(), e.getMessage() }, e);
        }

        return publishSuccess;
    }

    private Account buildDefaultAccount() {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setAmount(new Random().nextDouble());
        account.setGmtCreate(new Date());
        return account;
    }

    public void setMqPublisher(UniformEventPublisher mqPublisher) {
        this.mqPublisher = mqPublisher;
    }
}