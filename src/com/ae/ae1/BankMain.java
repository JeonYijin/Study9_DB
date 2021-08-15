package com.ae.ae1;

import java.util.ArrayList;

import com.ae.ae1.bankbook.BankBookDAO;
import com.ae.ae1.bankbook.BankBookDTO;
import com.ae.ae1.bankbook.BankBookView;
import com.ae.ae1.inout.InoutDAO;
import com.ae.ae1.inout.InoutDTO;
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
		//bankDto.setId("AE1");
		//bankDto = bankDAO.getOne(bankDto);
		bankDto.setMemberDTO(memberDTO);
		bankDto =bankDAO.getOne(bankDto);
//		BankBookView bankView = new BankBookView();
//		bankView.view(bankDto);
		
		
		InoutDAO inoutDAO = new InoutDAO();
		InoutDTO inoutDTO = new InoutDTO();
		
		System.out.println(bankDto.getBalance());
		inoutDTO.setTran_amount(5000);
		inoutDTO.setTran_check("true");
		inoutDTO.setTran_balance(bankDto.getBalance()+inoutDTO.getTran_amount());
		inoutDTO.setMemberDTO(memberDTO);
		int result = inoutDAO.trade(inoutDTO);
		
		System.out.println(result);
		
		
		
	}

}
