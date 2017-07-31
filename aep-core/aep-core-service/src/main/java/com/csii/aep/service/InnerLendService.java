package com.csii.aep.service;

import com.alipay.dtx.client.core.api.domain.BusinessActionContext;
import com.alipay.dtx.client.core.spi.TwoPhaseBusinessAction;
import com.csii.aep.facade.LendRequest;
import com.csii.aep.facade.LendResponse;

public interface InnerLendService {

	@TwoPhaseBusinessAction(name = "lend", commitMethod = "commit", rollbackMethod = "rollback")
	public LendResponse prepare(BusinessActionContext context, LendRequest request);

	public void commit(BusinessActionContext context);

	public void rollback(BusinessActionContext context);
}
