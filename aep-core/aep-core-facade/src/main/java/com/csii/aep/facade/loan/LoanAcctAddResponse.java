package com.csii.aep.facade.loan;

import java.math.BigDecimal;

public class LoanAcctAddResponse {
	public String acctno;
	public BigDecimal balance;
	public BigDecimal leftLimit;
	public String status;

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getLeftLimit() {
		return leftLimit;
	}

	public void setLeftLimit(BigDecimal leftLimit) {
		this.leftLimit = leftLimit;
	}

	@Override
	public String toString() {
		return "LoanAcctAddResponse [acctno=" + acctno + ", balance=" + balance + ", leftLimit=" + leftLimit
				+ ", status=" + status + "]";
	}


}
