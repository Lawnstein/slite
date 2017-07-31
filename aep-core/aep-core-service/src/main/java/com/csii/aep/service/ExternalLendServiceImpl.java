package com.csii.aep.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.dtx.client.core.integration.aop.DtxTransaction;
import com.csii.aep.facade.LendRequest;
import com.csii.aep.facade.LendResponse;
import com.csii.aep.facade.LendService;

public class ExternalLendServiceImpl implements LendService {
	private static final Logger logger = LoggerFactory.getLogger(ExternalLendServiceImpl.class);

	private InnerLendService innerLendService;

	public InnerLendService getInnerLendService() {
		return innerLendService;
	}

	public void setInnerLendService(InnerLendService innerLendService) {
		this.innerLendService = innerLendService;
	}

	@Override
	@DtxTransaction(bizType = "lend")
	public LendResponse lend(LendRequest request) {
		logger.info("Thread[{}], try to call ExternalLendServiceImpl.prepare(), request {}",
				Thread.currentThread().getName(), request);
		LendResponse r = innerLendService.prepare(null, request);
		logger.info("Thread[{}], call ExternalLendServiceImpl.prepare(), response {}", Thread.currentThread().getName(),
				r);
		return r;
	}

}
