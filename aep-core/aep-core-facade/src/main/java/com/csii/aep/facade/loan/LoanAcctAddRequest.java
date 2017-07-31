package com.csii.aep.facade.loan;

import java.math.BigDecimal;

public class LoanAcctAddRequest {
	public String acctno;
	public BigDecimal amount;

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

	@Override
	public String toString() {
		return "LoadAccAddRequest [acctno=" + acctno + ", amount=" + amount + "]";
	}

}
