package com.ae.ae1;

import java.util.ArrayList;

import com.ae.ae1.member.MemberController;
import com.ae.ae1.member.MemberDAO;
import com.ae.ae1.member.MemberDTO;
import com.ae.ae1.member.MemberView;

public class BankMain {

	public static void main(String[] args) {
		
//		MemberDAO mem = new MemberDAO();
//		MemberView memView = new MemberView();
//		MemberDTO memberDTO = new MemberDTO();
//		
//		
//		ArrayList<MemberDTO> ar = mem.getList();
//		
////		if(ar.size()>0) {
////			memView.view(ar);
////		}else {
////			System.out.println("없음");
////		}
//		MemberDTO member = new MemberDTO();
//		memberDTO.setId("AE1");
//		
//		member = mem.getOne(memberDTO);
//		memView.view(member);
		
		
		MemberController mc = new MemberController();
		mc.start();
		
		
		
		
		
		
	}

}
