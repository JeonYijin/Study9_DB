package com.ae.ae1;

import java.sql.Connection;
import java.sql.SQLException;

import com.ae.ae1.location.LocationDAO;
import com.ae.ae1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
		
		LocationDAO loc = new LocationDAO();
		
		loc.getList();
		
		
		
	}

}
