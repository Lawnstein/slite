package com.csii.aep.facade.loan;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.alipay.dtx.client.core.spi.TwoPhaseBusinessAction;

public interface LoanAcctAddService {

	@TwoPhaseBusinessAction(name = "add", commitMethod = "commit", rollbackMethod = "rollback")
	public LoanAcctAddResponse add(BusinessActionContext context, LoanAcctAddRequest request);

	public void commit(BusinessActionContext context);

	public void rollback(BusinessActionContext context);
}
