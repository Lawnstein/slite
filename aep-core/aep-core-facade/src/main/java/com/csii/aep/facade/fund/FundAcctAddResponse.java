package com.csii.aep.facade.fund;

import java.math.BigDecimal;

public class FundAcctAddResponse {

	public String acctno;
	public BigDecimal balance;
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
	@Override
	public String toString() {
		return "FundAcctAddResponse [acctno=" + acctno + ", balance=" + balance + ", status=" + status + "]";
	}
	
	
	
}
