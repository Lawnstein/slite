package com.csii.aep.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.csii.aep.facade.LendRequest;
import com.csii.aep.facade.LendResponse;
import com.csii.aep.facade.fund.FundAcctAddRequest;
import com.csii.aep.facade.fund.FundAcctAddResponse;
import com.csii.aep.facade.fund.FundAcctAddService;
import com.csii.aep.facade.loan.LoanAcctAddRequest;
import com.csii.aep.facade.loan.LoanAcctAddResponse;
import com.csii.aep.facade.loan.LoanAcctAddService;
import com.csii.aep.facade.loan.LoanOpenAcctRequest;
import com.csii.aep.facade.loan.LoanOpenAcctResponse;
import com.csii.aep.facade.loan.LoanOpenAcctService;

public class InnerLendServiceImpl implements InnerLendService {

	private static final Logger logger = LoggerFactory.getLogger(InnerLendServiceImpl.class);

	/**
	 * 贷款账户开户.
	 */
	@Autowired
	@Qualifier("loanOpenAcctServiceReference")
	private LoanOpenAcctService loanOpenAcctService;

	/**
	 * 内部账入账.
	 */
	@Autowired
	@Qualifier("loanAcctAddServiceReference")
	private LoanAcctAddService loanAcctAddService;

	/**
	 * 贷款账号放款.
	 */
	@Autowired
	@Qualifier("fundAcctAddServiceReference")
	private FundAcctAddService fundAcctAddService;

	@Override
	public LendResponse prepare(BusinessActionContext context, LendRequest request) {
		logger.info("Thread[{}], try to call InnerLendServiceImpl.prepare(), context {}, request {}",
				Thread.currentThread().getName(), context, request);

		/**
		 * 第一步，调用贷款借据开立、贷款账户开户。
		 */
		// public LoanOpenAcctResponse open(BusinessActionContext context,
		// LoanOpenAcctRequest request);
		LoanOpenAcctRequest loanOpenAcctRequest = new LoanOpenAcctRequest();
		loanOpenAcctRequest.setCustno(request.getCustno());
		loanOpenAcctRequest.setTerm(request.getTerm());
		logger.info("Thread[{}], try to call loanOpenAcctService.open(), context {}, request {}",
				Thread.currentThread().getName(), context, loanOpenAcctRequest);
		LoanOpenAcctResponse loanOpenAcctResponse = loanOpenAcctService.open(context, loanOpenAcctRequest);
		logger.info("Thread[{}], loanOpenAcctService.open() return, context {}, response {}",
				Thread.currentThread().getName(), context, loanOpenAcctResponse);

		/**
		 * 第二步，调用内部户入账.
		 */
		// public FundAcctAddResponse add(BusinessActionContext context,
		// FundAcctAddRequest request);
		FundAcctAddRequest fundAcctAddRequest = new FundAcctAddRequest();
		fundAcctAddRequest.setAcctno(loanOpenAcctResponse.getAcctno());
		fundAcctAddRequest.setAmount(request.getAmount());
		fundAcctAddRequest.setRemark("贷款放款，客户" + request.getCustno() + ", 期限" + request.getTerm());
		logger.info("Thread[{}], try to call fundAcctAddService.add(), context {}, request {}",
				Thread.currentThread().getName(), context, fundAcctAddRequest);
		FundAcctAddResponse fundAcctAddResponse = fundAcctAddService.add(context, fundAcctAddRequest);
		logger.info("Thread[{}], fundAcctAddService.add() return, context {}, response {}",
				Thread.currentThread().getName(), context, fundAcctAddResponse);

		/**
		 * 第三步，贷款入账。
		 */
		// public LoanAcctAddResponse add(BusinessActionContext context,
		// LoanAcctAddRequest request);
		LoanAcctAddRequest loanAcctAddRequest = new LoanAcctAddRequest();
		loanAcctAddRequest.setAcctno(loanOpenAcctResponse.getAcctno());
		loanAcctAddRequest.setAmount(request.getAmount());
		logger.info("Thread[{}], try to call loanAcctAddService.add(), context {}, request {}",
				Thread.currentThread().getName(), context, loanAcctAddRequest);
		LoanAcctAddResponse loanAcctAddResponse = loanAcctAddService.add(context, loanAcctAddRequest);
		logger.info("Thread[{}], loanAcctAddService.add() return, context {}, response {}",
				Thread.currentThread().getName(), context, loanAcctAddResponse);

		LendResponse lendResponse = new LendResponse();
		lendResponse.setAmount(request.getAmount());
		lendResponse.setIouNo(loanOpenAcctResponse.getAcctno());
		lendResponse.setLeftLimit(loanAcctAddResponse.getLeftLimit());
		lendResponse.setTerm(request.getTerm());

		logger.info("Thread[{}], InnerLendServiceImpl.prepare() return, context {}, response {}",
				Thread.currentThread().getName(), context, lendResponse);
		return lendResponse;
	}

	@Override
	public void commit(BusinessActionContext context) {
		logger.info("Thread[{}], try to call InnerLendServiceImpl.commit() commitcommitcommitcommitcommitcommitcommitcommitcommitcommitcommitcommitcommitcommitcommitcommit, context {}",
				Thread.currentThread().getName(), context);

	}

	@Override
	public void rollback(BusinessActionContext context) {
		logger.error("Thread[{}], try to call InnerLendServiceImpl.rollback() rollbackrollbackrollbackrollbackrollbackrollbackrollbackrollbackrollbackrollbackrollbackrollbackrollback, context {}",
				Thread.currentThread().getName(), context);
	}

}
