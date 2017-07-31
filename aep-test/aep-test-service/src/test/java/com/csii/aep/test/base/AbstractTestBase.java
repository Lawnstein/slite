package com.csii.aep.test.base;

import com.csii.aep.Slite2SpringBootApplicationClient;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AbstractTestBase
 * <p>
 * 参考文档: http://docs.spring.io/spring-boot/docs/1.4.2.RELEASE/reference/htmlsingle/#boot-features-testing
 * <p/>
 * Created by yangguanchao on 16/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ImportResource({"classpath*:test/META-INF/aep-test/test.xml"})
@SpringBootTest(classes = Slite2SpringBootApplicationClient.class)
public abstract class AbstractTestBase {

    public static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    @Autowired
    protected ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
    }
    
    protected void println(String message) {
    	System.out.println(message);
    	System.out.flush();
    }
}