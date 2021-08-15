package com.ae.ae1.bankbook;

public class BankBookView {
	
	public void view(BankBookDTO bankBookDTO) {
		System.out.println(bankBookDTO.getIssue_date());
		System.out.println(bankBookDTO.getPro_name());
		System.out.println(bankBookDTO.getAccount());
		System.out.println(bankBookDTO.getBalance());
		System.out.println(bankBookDTO.getMemberDTO().getId());
		
	}
	
	
}
