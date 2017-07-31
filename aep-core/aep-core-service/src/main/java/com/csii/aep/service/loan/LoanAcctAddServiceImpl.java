package com.csii.aep.service.loan;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.csii.aep.facade.loan.LoanAcctAddRequest;
import com.csii.aep.facade.loan.LoanAcctAddResponse;
import com.csii.aep.facade.loan.LoanAcctAddService;

public class LoanAcctAddServiceImpl implements LoanAcctAddService {
	private static final Logger logger = LoggerFactory.getLogger(LoanAcctAddServiceImpl.class);

	@Override
	public LoanAcctAddResponse add(BusinessActionContext context, LoanAcctAddRequest request) {
		logger.info("Thread[{}], try to call LoanAcctAddServiceImpl.add(), context {}, request {}",
				Thread.currentThread().getName(), context, request);
		if (request.getAmount().compareTo(BigDecimal.ZERO) < 0) {
			logger.error("invalid loan amount " + request.getAmount() + ", too small.");
			throw new RuntimeException("Invalid loan amount " + request.getAmount());
		}
		if (request.getAmount().compareTo(new BigDecimal(90000000)) > 0) {
			logger.error("invalid loan amount " + request.getAmount() + ", too large.");
			throw new RuntimeException("Invalid loan amount " + request.getAmount());
		}

		LoanAcctAddResponse r = new LoanAcctAddResponse();
		r.setAcctno(request.getAcctno());
		r.setBalance(request.getAmount().add(new BigDecimal(8888)));
		r.setLeftLimit((new BigDecimal(90000000)).subtract(r.getBalance()));
		r.setStatus("0");
		return r;
	}

	@Override
	public void commit(BusinessActionContext context) {
		logger.info("Thread[{}], try to call LoanAcctAddServiceImpl.commit(), !!!!!!!!!!!!! context {}",
				Thread.currentThread().getName(), context);
	}

	@Override
	public void rollback(BusinessActionContext context) {
		logger.error("Thread[{}], try to call LoanAcctAddServiceImpl.rollback(), ?????????????? context {}",
				Thread.currentThread().getName(), context);
	}

}
