package com.csii.aep.test.usercases;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.csii.aep.facade.LendRequest;
import com.csii.aep.facade.LendResponse;
import com.csii.aep.facade.LendService;
import com.csii.aep.facade.SampleService;
import com.csii.aep.test.base.AbstractTestBase;

/**
 * BeanTest
 * <p>
 * Created by yangguanchao on 16/12/9.
 */
public class BeanTest extends AbstractTestBase {

	@Autowired
	private SampleService sampleService;

	@Autowired
	private LendService lendService;

	@Test
	public void testRpcSimple() throws Exception {
		println("call BeanTest.testRpcSimple() >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		try {
			String result = sampleService.message("Lucy");
			println("Sample Service Result = " + result);
			Assert.assertTrue(result != null && result.length() > 0);
		} catch (Throwable th) {
			th.printStackTrace();
		}
		println("call BeanTest.testRpcSimple() <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	@Test
	public void testLendNormal() throws Exception {
		println("call BeanTest.testLendNormal() >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			Random r = new Random(System.currentTimeMillis());
			LendRequest request = new LendRequest();
			request.setCustno("01000543");
			request.setAmount(new BigDecimal(r.nextInt(900)));
			request.setTerm("3M");

			println("LendService Service Request = " + request);
			LendResponse response = lendService.lend(request);
			println("LendService Service Response = " + response);
		} catch (Throwable th) {
			th.printStackTrace();
		}
		println("call BeanTest.testLendNormal() <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	@Test
	public void testLendError() throws Exception {
		println("call BeanTest.testLendError() >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			Random r = new Random(System.currentTimeMillis());
			LendRequest request = new LendRequest();
			request.setCustno("01000543");
			request.setAmount(new BigDecimal(90000001));
			request.setTerm("3M");

			println("LendService Service Request = " + request);
			LendResponse response = lendService.lend(request);
			println("LendService Service Response = " + response);
		} catch (Throwable th) {
			th.printStackTrace();
		}
		println("call BeanTest.testLendError() <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
