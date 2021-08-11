package com.ae.ae1.department;

import java.util.ArrayList;

import com.ae.ae1.employee.EmployeeDTO;


public class Depar_EmpDTO extends DepartmentDTO {

	private ArrayList<EmployeeDTO> ar;

	public ArrayList<EmployeeDTO> getAr() {
		return ar;
	}

	public void setAr(ArrayList<EmployeeDTO> ar) {
		this.ar = ar;
	}
	
	
}
