package com.csii.aep.facade.fund;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.alipay.dtx.client.core.spi.TwoPhaseBusinessAction;

public interface FundAcctAddService {
	
	@TwoPhaseBusinessAction(name = "add", commitMethod = "commit", rollbackMethod = "rollback")
	public FundAcctAddResponse add(BusinessActionContext context, FundAcctAddRequest request);

	public void commit(BusinessActionContext context);

	public void rollback(BusinessActionContext context);
}
