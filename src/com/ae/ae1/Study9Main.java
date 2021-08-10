package com.ae.ae1;

import java.sql.Connection;
import java.sql.SQLException;

import com.ae.ae1.employee.EmployeeController;
import com.ae.ae1.location.LocationController;
import com.ae.ae1.location.LocationDAO;
import com.ae.ae1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
//		LocationController lc = new LocationController();
//		lc.start();
		
		EmployeeController ec = new EmployeeController();
		ec.start();
		
		
	}

}
