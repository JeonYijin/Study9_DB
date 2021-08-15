package com.ae.ae1.member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	
	private Scanner sc;
	private MemberDAO memberDAO;
	private MemberView memberView;
	private MemberInput memberInput;
	
	
	public MemberController() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
		memberView = new MemberView();
		memberInput = new MemberInput();
	}
	
	
	public void start() {
		//전체 회원 조회하기
		
		//회원 한명 조회하기
		//회원 추가하기
		//회원 탈퇴하기
		//종료
		boolean check = true;
		while(check) {
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 회원 한명 조회");
			System.out.println("3. 회원 가입");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 종료");
			
			int select = sc.nextInt();
			
			if(select ==1) {
				ArrayList<MemberDTO> ar = new ArrayList<>();
				ar = memberDAO.getList();
				if(ar.size()>0) {
					memberView.view(ar);
				}else {
					memberView.view("없음");
				}
				
			}else if(select == 2) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO = memberInput.inputId(sc);
				MemberDTO memberDTO2 = memberDAO.getOne(memberDTO);
				if(memberDTO2 != null) {
					memberView.view(memberDTO2);
				}else {
					memberView.view("없음");
				}
				
			}else if(select == 3) {
				MemberDTO memberDTO = new MemberDTO();
				ArrayList<MemberDTO> ar = memberInput.input(sc);
				
				int result =0;
				result = memberDAO.setMember(ar.get(0));
				if(result>0) {
					System.out.println("생성되었습니다");
				}else {
					System.out.println("실패");
				}
			}else if(select == 4) {
				MemberDTO memberDTO = new MemberDTO();
				int result =0;
				memberDTO = memberInput.inputId(sc);
				result = memberDAO.delete(memberDTO);
				if(result>0) {
					memberView.view("삭제");
				}else {
					memberView.view("삭제 실패");
				}
			}else {
				check = false;
			}
			
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	
}
