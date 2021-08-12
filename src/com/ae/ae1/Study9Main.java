package com.ae.ae1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.location.LocationController;
import com.ae.ae1.location.LocationDAO;
import com.ae.ae1.location.LocationDTO;
import com.ae.ae1.location.LocationView;
import com.ae.ae1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
		
		LocationController lc = new LocationController();
		lc.start();

//		LocationDAO locationDAO = new LocationDAO();
//		LocationDTO locationDTO = new LocationDTO();
//		locationDTO.setLocation_id(1000);
//		locationDTO = locationDAO.getOne(locationDTO);
//		
//		if(locationDTO != null) {
//			System.out.println(locationDTO.getLocation_id());
//			System.out.println(locationDTO.getStreet_address());
//			System.out.println(locationDTO.getCity());
//		}else {
//			System.out.println("조회 실패");
//		}

		
//		LocationDAO locationDAO = new LocationDAO();
//		ArrayList<LocationDTO> ar = locationDAO.getList();
//		
//		LocationView locationView = new LocationView();
//		locationView.view(ar);
		
		
//		if(ar.size() !=0) {
//			for(int i=0; i< ar.size(); i++) {
//				System.out.println(ar.get(i).getLocation_id());
//				System.out.println(ar.get(i).getStreet_address());
//				System.out.println(ar.get(i).getPostal_code());
//				System.out.println(ar.get(i).getCity());
//				System.out.println(ar.get(i).getState_province());
//				System.out.println(ar.get(i).getCountry_id());
//				System.out.println("==========================");
//			}
//			
//		}else {
//			System.out.println("조회 실패");
//		}
		
		
			
		
		
	}

}
