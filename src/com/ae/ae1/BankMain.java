package com.ae.ae1;

import java.util.ArrayList;

import com.ae.ae1.bankbook.BankBookDAO;
import com.ae.ae1.bankbook.BankBookDTO;
import com.ae.ae1.bankbook.BankBookView;
import com.ae.ae1.member.MemberController;
import com.ae.ae1.member.MemberDAO;
import com.ae.ae1.member.MemberDTO;
import com.ae.ae1.member.MemberView;

public class BankMain {

	public static void main(String[] args) {
		
//		MemberController mc = new MemberController();
//		mc.start();
		
		BankBookDAO bankDAO = new BankBookDAO();
		BankBookDTO bankDto = new BankBookDTO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("AE2");
		bankDto.setMemberDTO(memberDTO);
		BankBookDTO bankDto2 =bankDAO.getOne(bankDto);
		
		BankBookView bankView = new BankBookView();
		bankView.view(bankDto2);
		
		
		
	}

}
