package com.alipay.share.rpc.test.usercases;

import com.alipay.share.rpc.facade.SampleService;
import com.alipay.share.rpc.test.base.AbstractTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BeanTest
 * <p>
 * Created by yangguanchao on 16/12/9.
 */
public class BeanTest extends AbstractTestBase {

    @Autowired
    private SampleService sampleService;

    @Test
    public void testRpcSimple() throws Exception {
        String result = sampleService.message();
        System.out.printf("Sample Service Result = " + result);
        Assert.assertTrue(result != null && result.length() > 0);
    }
}
