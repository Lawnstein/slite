package com.csii.aep.service.loan;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.csii.aep.facade.loan.LoanOpenAcctRequest;
import com.csii.aep.facade.loan.LoanOpenAcctResponse;
import com.csii.aep.facade.loan.LoanOpenAcctService;

public class LoanOpenAcctServiceImpl implements LoanOpenAcctService {
	private static final Logger logger = LoggerFactory.getLogger(LoanOpenAcctServiceImpl.class);

	@Override
	public LoanOpenAcctResponse open(BusinessActionContext context, LoanOpenAcctRequest request) {
		logger.info("Thread[{}], try to call LoanOpenAcctServiceImpl.add(), context {}, request {}",
				Thread.currentThread().getName(), context, request);
		Random ran = new Random(System.currentTimeMillis());

		LoanOpenAcctResponse r = new LoanOpenAcctResponse();
		r.setAcctno("98001" + ran.nextInt(10000));
		r.setCustno(request.getCustno());
		return r;
	}

	@Override
	public void commit(BusinessActionContext context) {
		logger.info("Thread[{}], try to call LoanOpenAcctServiceImpl.commit(), =====!!!!!!!!!!!!!===== context {}",
				Thread.currentThread().getName(), context);
	}

	@Override
	public void rollback(BusinessActionContext context) {
		logger.error(
				"Thread[{}], try to call LoanOpenAcctServiceImpl.rollback(), =====?????????????????????===== context {}",
				Thread.currentThread().getName(), context);
	}

}
