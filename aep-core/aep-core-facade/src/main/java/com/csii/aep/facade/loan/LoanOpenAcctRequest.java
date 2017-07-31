package com.csii.aep.facade.loan;

public class LoanOpenAcctRequest {
	public String custno;

	public String term;

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "LoanOpenAcctRequest [custno=" + custno + ", term=" + term + "]";
	}

}
