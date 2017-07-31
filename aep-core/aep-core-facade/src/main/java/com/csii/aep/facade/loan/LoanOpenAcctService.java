package com.csii.aep.facade.loan;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.alipay.dtx.client.core.spi.TwoPhaseBusinessAction;

public interface LoanOpenAcctService {
	
	@TwoPhaseBusinessAction(name = "open", commitMethod = "commit", rollbackMethod = "rollback")
	public LoanOpenAcctResponse open(BusinessActionContext context, LoanOpenAcctRequest request);

	public void commit(BusinessActionContext context);

	public void rollback(BusinessActionContext context);
}
