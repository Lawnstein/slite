package com.csii.aep.test.usercases;

import com.csii.aep.facade.LendRequest;
import com.csii.aep.facade.LendResponse;
import com.csii.aep.facade.LendService;
import com.csii.aep.facade.SampleService;
import com.csii.aep.test.base.AbstractTestBase;

import java.math.BigDecimal;

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

	@Autowired
	private LendService lendService;

	@Test
	public void testRpcSimple() throws Exception {
		System.out.println(">>>>>>>>>>>>>> Client test");
		System.out.flush();
		String result = sampleService.message("Johnn");
		System.out.println("<<<<<<<<<<<<<< Sample Service Result = " + result);
		System.out.flush();
		Assert.assertTrue(result != null && result.length() > 0);
	}

	@Test
	public void testLend() throws Exception {
		try {
			LendRequest request = new LendRequest();
			request.setCustno("01000543");
			request.setAmount(new BigDecimal(99.00));
			request.setTerm("3M");

			System.out.println(">>>>>>>>> LendService Service Request = " + request);
			System.out.flush();
			LendResponse response = lendService.lend(request);
			System.out.println("<<<<<<<<< LendService Service Response = " + response);
			System.out.flush();
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}
}
