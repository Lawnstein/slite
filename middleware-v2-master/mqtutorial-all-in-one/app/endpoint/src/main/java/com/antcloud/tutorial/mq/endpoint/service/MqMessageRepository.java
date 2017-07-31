/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq.endpoint.service;

import java.util.ArrayList;
import java.util.List;

import com.antcloud.tutorial.mq.endpoint.model.MqMessage;

public class MqMessageRepository {

    private static MqMessageRepository repo     = new MqMessageRepository();

    private List<MqMessage>            messages = new ArrayList<MqMessage>(10);

    private MqMessageRepository() {
    }

    public static MqMessageRepository getInstance() {
        return repo;
    }

    public void add(MqMessage mqMessage) {
        messages.add(mqMessage);
    }

    public List<MqMessage> queryAll() {
        return messages;
    }

}
