package com.alipay.share.rpc.reference;

import com.alipay.share.rpc.facade.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Slite2SpringBootsofa2-rpcserverApplication
 * <p>
 * Create a non-web application:
 * http://docs.spring.io/spring-boot/docs/1.4.2.RELEASE/reference/htmlsingle/#howto-create-a-non-web-application
 * <p>
 * <p>
 * Created by yangguanchao on 16/12/9.
 */
@ImportResource({"classpath*:META-INF/sofa2-rpc-client/*.xml"})
@org.springframework.boot.autoconfigure.SpringBootApplication
public class Slite2SpringBootApplication {
    public static void main(String[] args) throws Exception {

        SpringApplication springApplication = new SpringApplication(Slite2SpringBootApplication.class);
        //a non-web application
        springApplication.setWebEnvironment(false);
        ApplicationContext applicationContext = springApplication.run(args);
        SampleService sampleService = applicationContext.getBean(SampleService.class);
        //等待地址
        Thread.sleep(3000);
        System.out.println("Sample Service Result = " + sampleService.message());
        System.out.println("Current Client Application Context : " + applicationContext);
    }
}
