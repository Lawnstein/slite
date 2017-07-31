package com.csii.aep.facade;

import java.math.BigDecimal;

public class LendResponse {

	public String iouNo;
	public BigDecimal amount;
	public BigDecimal leftLimit;
	public String term;

	public String getIouNo() {
		return iouNo;
	}

	public void setIouNo(String iouNo) {
		this.iouNo = iouNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getLeftLimit() {
		return leftLimit;
	}

	public void setLeftLimit(BigDecimal leftLimit) {
		this.leftLimit = leftLimit;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "LendResponse [iouNo=" + iouNo + ", amount=" + amount + ", leftLimit=" + leftLimit + ", term=" + term
				+ "]";
	}

}
