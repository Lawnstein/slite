/**
 * Alipay.com Inc.
 * Copyright (c) 2004-YEARALL Rights Reserved
 */
package com.antcloud.tutorial.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath*:META-INF/mqtutorial-publish-message/*.xml" })
@org.springframework.boot.autoconfigure.SpringBootApplication
public class Slite2WebSpringBootApplication {

    public static void main(String[] args) throws Exception {
        new SpringApplication(Slite2WebSpringBootApplication.class).run(args);
    }
}
