/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventContext;
import com.alipay.common.event.UniformEventMessageListener;

/**
 * MQ message listener implements the logic to handle the messages subscribed.
 *
 */
public class MqMessageListener implements UniformEventMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MqMessageListener.class);

    @Override
    public void onUniformEvent(UniformEvent message, UniformEventContext context) throws Exception {

        /* get TOPIC, EVENTCODE and payload from the message instance */
        final String topic = message.getTopic();
        final String eventcode = message.getEventCode();
        final String id = message.getId();
        final Object businessObject = message.getEventPayload();

        logger.info("Receive a message, TOPIC [{}] EVENTCODE [{}] id [{}] payload [{}]", new Object[] { topic,
                eventcode, id, businessObject });

        try {
            boolean processSuccess = processMessage(businessObject);

            if (!processSuccess) {
                /* Process the message failure, set cause and rollback, the message is re-delivered later. */
                context.setContextDesc("process error cause");
                context.setRollbackOnly();
            }
        } catch (Exception e) {
            logger.error("Process a message, failure. TOPIC [{}] EVENTCODE [{}] id [{}] error {}", new Object[] {
                    topic, eventcode, id, e.getMessage() }, e);
            /* When any exception is thrown, the message is re-delivered later. */
            throw e;
        }
    }

    /* Process the business logic */
    private boolean processMessage(Object businessObject) {
        return true;
    }
}
