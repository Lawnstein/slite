package com.csii.aep.service.fund;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.csii.aep.facade.fund.FundAcctAddRequest;
import com.csii.aep.facade.fund.FundAcctAddResponse;
import com.csii.aep.facade.fund.FundAcctAddService;

public class FundAcctAddServiceImpl implements FundAcctAddService {
	private static final Logger logger = LoggerFactory.getLogger(FundAcctAddServiceImpl.class);

	@Override
	public FundAcctAddResponse add(BusinessActionContext context, FundAcctAddRequest request) {
		logger.info("Thread[{}], try to call FundAcctAddServiceImpl.add(), context {}, request {}",
				Thread.currentThread().getName(), context, request);
		FundAcctAddResponse r = new FundAcctAddResponse();
		r.setAcctno(request.getAcctno());
		r.setBalance(request.getAmount().add(new BigDecimal(10000)));
		r.setStatus("0");
		return r;
	}

	@Override
	public void commit(BusinessActionContext context) {
		logger.info("Thread[{}], try to call FundAcctAddServiceImpl.commit() commitcommitcommitcommitcommitcommitcommitcommitcommitcommit,  !!!!!!!!!!!!! context {}",
				Thread.currentThread().getName(), context);
	}

	@Override
	public void rollback(BusinessActionContext context) {
		logger.error("Thread[{}], try to call FundAcctAddServiceImpl.rollback() rollbackrollbackrollbackrollbackrollbackrollbackrollbackrollbackrollback, ???????????????????????????????????? context {}",
				Thread.currentThread().getName(), context);
	}

}
