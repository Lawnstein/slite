package com.csii.aep.facade;

import java.math.BigDecimal;

public class LendRequest {
	public String custno;
	public BigDecimal amount;
	public String term;

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "LendRequest [custno=" + custno + ", amount=" + amount + ", term=" + term + "]";
	}

}
