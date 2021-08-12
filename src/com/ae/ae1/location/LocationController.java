package com.ae.ae1.location;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	private LocationInput locationInput;
	private Scanner sc;

	public LocationController() {
		locationDAO = new LocationDAO();
		this.locationView = new LocationView();
		sc = new Scanner(System.in);
		locationInput = new LocationInput();
	}
	
	public void start() {
		
		//1. 로케이션 모든 정보 2. ID 받아서 해당 LOCATION 정보 출력 3. 종료
		//정보 출력 후 다시 고르기
		boolean check = true;
		while(check) {
			System.out.println("1. 전체 정보 출력");
			System.out.println("2. 한개 정보 출력");
			System.out.println("3. 지역 정보 추가");
			System.out.println("4. 지역 정보 삭제");
			System.out.println("5. 종료");
			int select = sc.nextInt();
			
			if(select == 1) {
				ArrayList<LocationDTO> ar =locationDAO.getList();
				if(ar.size()>0) {
					locationView.view(ar);
				}else {
					locationView.view("데이터 없음");
				}
				
			}else if (select ==2) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO = locationInput.inputId(sc);
				locationDTO = locationDAO.getOne(locationDTO);
				if(locationDTO != null) {
					locationView.view(locationDTO);
				}else {
					locationView.view("없는 id");
				}
				
				
			}else if(select == 3){
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(3800);
				locationDTO.setStreet_address("AEAEAE");
				locationDTO.setPostal_code("121312");
				locationDTO.setCity("Seoul");
				locationDTO.setState_province("null");
				locationDTO.setCountry_id("US");
				int result =0;
				result = locationDAO.setLocation(locationDTO);
				
				if(result>0) {
					locationView.view("성공");
				}else {
					locationView.view("실패");
				}
				
			}else if(select == 4) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(3800);
				int result =0;
				
				result = locationDAO.delete(locationDTO);
				if(result>0) {
					locationView.view("성공");
				}else {
					locationView.view("실패");
				}
				
			}else {
				//check = false;
				break;
			}
			
			
		}
		
		
		
		
	}
	
	
}
