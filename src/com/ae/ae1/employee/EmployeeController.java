package com.ae.ae1.employee;

import java.util.ArrayList;

public class EmployeeController {

	public void start() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeView employeeView = new EmployeeView();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		ArrayList<EmployeeDTO> ar = employeeDAO.getList();
		//employeeView.view(ar);
		//employeeDTO = employeeDAO.getOne(100);
		//employeeView.view(employeeDTO);
		
		//ArrayList<EmployeeDTO> ar2 = employeeDAO.getLast("K");
		ArrayList<EmployeeDTO> ar3 = employeeDAO.getFirst("s");
		//employeeView.view(ar3);
		
		//double d = employeeDAO.getAvg();
		//System.out.println(d);
		
		ArrayList<Double> dd = employeeDAO.getDpAvg();
		employeeView.view2(dd);
		
		
		
		
	}
	
	
}
