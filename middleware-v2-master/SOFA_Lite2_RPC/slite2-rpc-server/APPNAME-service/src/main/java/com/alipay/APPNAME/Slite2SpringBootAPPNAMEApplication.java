package com.alipay.APPNAME;

import com.alipay.APPNAME.facade.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

/**
 * Slite2SpringBootAPPNAMEApplication
 * <p>
 * Create a non-web application:
 * http://docs.spring.io/spring-boot/docs/1.4.2.RELEASE/reference/htmlsingle/#howto-create-a-non-web-application
 * <p>
 * <p>
 * Created by yangguanchao on 16/12/9.
 */
@ImportResource({"classpath*:META-INF/APPNAME/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class Slite2SpringBootAPPNAMEApplication {
    public static void main(String[] args) throws Exception {

        SpringApplication springApplication = new SpringApplication(Slite2SpringBootAPPNAMEApplication.class);
        //a non-web application
        springApplication.setWebEnvironment(false);
        ApplicationContext applicationContext = springApplication.run(args);
        Environment environment = applicationContext.getEnvironment();

        SampleService sampleService = applicationContext.getBean(SampleService.class);
        System.out.println("Sample Service Result = " + sampleService.message());
        System.out.println("Current Application Context : " + applicationContext);
    }
}
