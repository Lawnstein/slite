/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.antcloud.tutorial.scheduler;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Scheduled task by quartz.
 *
 * @author zhongwang.zw
 * @version $Id: QuartzDemo.java, v 0.1 2017-07-04 17:39 your_name Exp $
 */
public class QuartzDemo {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzDemo.class);

//    public static void main(String[] args) {
//
//        String cronExp = "0/5 * * * * ? *";
//        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
//
//        try {
//            // 通过schedulerFactory获取一个调度器
//            Scheduler scheduler = schedulerfactory.getScheduler();
//            // 创建jobDetail实例，绑定Job实现类
//            // 指明job的名称，所在组的名称，以及绑定job类
//            JobDetail jobDetail = new JobDetail("job1", "jgroup1", QuartzTask.class);
//
//            // 定义调度触发规则，频率
//            CronTrigger cornTrigger = new CronTrigger("cronTrigger", "triggerGroup");
//            cornTrigger.setCronExpression(cronExp);
//            // 把作业和触发器注册到任务调度中
//            scheduler.scheduleJob(jobDetail, cornTrigger);
//
//            // 启动调度
//            scheduler.start();
//        } catch (SchedulerException e) {
//            LOGGER.error("Error when getScheduler", e);
//        } catch (ParseException e) {
//            LOGGER.error("Cron expression [{}] illegal", cronExp, e);
//        }
//    }

}
