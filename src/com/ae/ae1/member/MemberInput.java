package com.ae.ae1.member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberInput {

	public MemberDTO inputId(Scanner sc) {
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("ID를 입력하세요.");
		String member_id = sc.next();
		
		memberDTO.setId(member_id);
		return memberDTO;
		
	}
	
	public ArrayList<MemberDTO> input(Scanner sc) {
		ArrayList<MemberDTO> ar = new ArrayList<>();
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("id >>");
		String member_id = sc.next();
		System.out.println("PW >>");
		int member_pw = sc.nextInt();
		System.out.println("NAME>>");
		String member_name = sc.next();
		System.out.println("phone>>");
		String member_phone = sc.next();
		System.out.println("EMAIL>>");
		String member_email = sc.next();
		
	
			memberDTO.setId(member_id);
			memberDTO.setPw(member_pw);
			memberDTO.setName(member_name);
			memberDTO.setPhone(member_phone);
			memberDTO.setEmail(member_email);
			
			ar.add(memberDTO);
		
		
		
		return ar;
	}
	
	
	
	
}
