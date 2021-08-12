package com.ae.ae1.location;

import java.util.ArrayList;

public class LocationView {
	
	public void view(LocationDTO locationDTO) {
		
		System.out.println(locationDTO.getLocation_id());
		System.out.println(locationDTO.getCity());
		System.out.println(locationDTO.getCountry_id());
	}
	
	public void view(ArrayList<LocationDTO> ar) {
		

			for(int i=0; i< ar.size(); i++) {
				
				this.view(ar.get(i));
			}
			
	
	}
	
	public void view(String msg) {
		System.out.println(msg);
		
	}
	
	
	
	
	
	
	
	
	
}
