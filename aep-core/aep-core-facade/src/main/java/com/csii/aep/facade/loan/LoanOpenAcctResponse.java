package com.csii.aep.facade.loan;

public class LoanOpenAcctResponse {
	public String custno;
	public String acctno;

	public String getCustno() {
		return custno;
	}

	public void setCustno(String custno) {
		this.custno = custno;
	}

	public String getAcctno() {
		return acctno;
	}

	public void setAcctno(String acctno) {
		this.acctno = acctno;
	}

	@Override
	public String toString() {
		return "LoanOpenAcctResponse [custno=" + custno + ", acctno=" + acctno + "]";
	}

}
