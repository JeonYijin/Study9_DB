package com.ae.ae1.member;

import java.util.ArrayList;

public class MemberView {
	
	public void view(MemberDTO memberDTO) {

		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPw());
		System.out.println(memberDTO.getName());
		System.out.println(memberDTO.getPhone());
		System.out.println(memberDTO.getEmail());
		System.out.println("==============");
	}
	
	
	public void view(ArrayList<MemberDTO> ar) {
		for(int i=0; i<ar.size(); i++) {
			this.view(ar.get(i));
		}
	}
	
	
	public void view(String msg) {
		System.out.println(msg);
	}
	
	
}
