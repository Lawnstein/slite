/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.antcloud.tutorial.scheduler;

import com.alipay.common.event.UniformEvent;
import com.alipay.common.event.UniformEventContext;
import com.alipay.common.event.UniformEventMessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Scheduled task by mq.
 * 
 * @author zhongwang.zw
 * @version $Id: SchedulerDemo.java, v 0.1 2017-07-04 17:20 your_name Exp $
 */
public class SchedulerDemo implements UniformEventMessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerDemo.class);

    /**
     * @see SchedulerDemo#onUniformEvent
     */
    @Override
    public void onUniformEvent(UniformEvent uniformEvent, UniformEventContext uniformEventContext)
                                                                                                  throws Exception {
        final String topic = uniformEvent.getTopic();
        final String eventCode = uniformEvent.getEventCode();

        // 接收触发后的定时业务处理
        LOGGER.info("[Receive an schedule trigger] taskName/EVENTCODE [{}] TOPIC [{}]", eventCode,
            topic);
    }
}
