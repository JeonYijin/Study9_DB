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
			System.out.println("3. 종료");
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
				
				
			}else {
				//check = false;
				break;
			}
			
			
		}
		
		
		
		
	}
	
	
}
