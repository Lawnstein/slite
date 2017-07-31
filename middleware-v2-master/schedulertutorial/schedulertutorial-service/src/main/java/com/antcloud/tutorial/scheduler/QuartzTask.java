/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.antcloud.tutorial.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhongwang.zw
 * @version $Id: QuartzTask.java, v 0.1 2017-07-04 17:34 your_name Exp $
 */
public class QuartzTask implements Job {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzTask.class);

    private int                 count  = 0;

    /**
     * @see QuartzTask#execute
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Random random = new Random();
        if (random.nextInt(10) == 3) {
            LOGGER.info("[Quartz task] delay for sometime");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info("[Quartz task] resume");
        }
        LOGGER.info("[Quartz task] executed at {}", dateFormat.format(new Date()));
    }

}
