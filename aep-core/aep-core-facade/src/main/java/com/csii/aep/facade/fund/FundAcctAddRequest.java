package com.csii.aep.facade.fund;

import java.math.BigDecimal;

public class FundAcctAddRequest {
	public String acctno;
	public BigDecimal amount;
	public String remark;
	
	public String getAcctno() {
		return acctno;
	}
	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "FundAcctAddRequest [acctno=" + acctno + ", amount=" + amount + ", remark=" + remark + "]";
	}
	
}
