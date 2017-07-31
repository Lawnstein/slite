package com.csii.aep;

import com.csii.aep.facade.SampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * Slite2SpringBootaep-coreApplication
 * <p>
 * Create a non-web application:
 * http://docs.spring.io/spring-boot/docs/1.4.2.RELEASE/reference/htmlsingle/#
 * howto-create-a-non-web-application
 * <p>
 * <p>
 * Created by yangguanchao on 16/12/9.
 */
@ImportResource({ "classpath*:META-INF/aep-core/*.xml" })
@org.springframework.boot.autoconfigure.SpringBootApplication
public class Slite2SpringBootApplicationSvr {
	public static void main(String[] args) throws Exception {

		SpringApplication springApplication = new SpringApplication(Slite2SpringBootApplicationSvr.class);
		// a non-web application
		springApplication.setWebEnvironment(false);
		ApplicationContext applicationContext = springApplication.run(args);
		// SampleService sampleService =
		// applicationContext.getBean(SampleService.class);
		// System.out.println("Sample Service Result = " +
		// sampleService.message());
		System.out.println("Current Application Context : " + applicationContext);
		System.out.println("Current Server Application Beans : ");
		for (String s : applicationContext.getBeanDefinitionNames())
			System.out.println("	" + s);

	}
}
