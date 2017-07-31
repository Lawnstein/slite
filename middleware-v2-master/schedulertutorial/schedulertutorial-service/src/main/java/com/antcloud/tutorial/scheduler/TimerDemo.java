/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.antcloud.tutorial.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Scheduled task by java.util.Timer
 *
 * @author zhongwang.zw
 * @version $Id: TimerDemo.java, v 0.1 2017-07-04 17:31 your_name Exp $
 */
public class TimerDemo {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(TimerDemo.class);

//    public static void main(String[] args) {
//        Task task = new Task();
//        Timer timer = new Timer();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        LOGGER.info("[Timer task] start after 1000: {}", dateFormat.format(new Date()));
//        timer.schedule(task, 1000, 5000);
//    }

    static class Task extends TimerTask {

        private int count = 0;

        /**
         * @see com.antcloud.tutorial.scheduler.TimerDemo.Task#run
         */
        @Override
        public void run() {
            count++;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            if (2 == count) {
                LOGGER.info("[Timer task] delay for sometime: {}", dateFormat.format(new Date()));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.info("[Timer task] resume: {}", dateFormat.format(new Date()));
            }
            LOGGER.info("[Timer task] executed: {} at {}", count, dateFormat.format(new Date()));
        }
    }

}
