package com.alipay.APPNAME.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Slite2WebSpringBootApplication
 * <p/>
 * Created by yangguanchao on 16/7/22.
 */
@ImportResource({"classpath*:META-INF/APPNAME/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class Slite2WebSpringBootApplication {

    // logger facade instance
    private static final Logger logger = LoggerFactory.getLogger(Slite2WebSpringBootApplication.class);

    public static void main(String[] args) throws Exception {

        SpringApplication springApplication = new SpringApplication(Slite2WebSpringBootApplication.class);
        ApplicationContext applicationContext = springApplication.run(args);
    }
}
