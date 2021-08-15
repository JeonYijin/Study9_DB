package com.ae.ae1.inout;

import java.sql.Date;

import com.ae.ae1.member.MemberDTO;

public class InoutDTO {
	
	private Date tran_date;
	private double tran_amount;
	private String tran_check;
	private double tran_balance;
	private MemberDTO memberDTO;
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	public double getTran_amount() {
		return tran_amount;
	}
	public void setTran_amount(double tran_amount) {
		this.tran_amount = tran_amount;
	}
	public String getTran_check() {
		return tran_check;
	}
	public void setTran_check(String tran_check) {
		this.tran_check = tran_check;
	}
	public double getTran_balance() {
		return tran_balance;
	}
	public void setTran_balance(double tran_balance) {
		this.tran_balance = tran_balance;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	
	
	
	
}
