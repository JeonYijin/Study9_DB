package com.ae.ae1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.department.Depar_EmpDTO;
import com.ae.ae1.department.DepartmentDAO;
import com.ae.ae1.department.DepartmentDTO;
import com.ae.ae1.employee.EmployeeController;
import com.ae.ae1.employee.EmployeeDTO;
import com.ae.ae1.location.LocationController;
import com.ae.ae1.location.LocationDAO;
import com.ae.ae1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
//		LocationController lc = new LocationController();
//		lc.start();
		
//		EmployeeController ec = new EmployeeController();
//		ec.start();
		
//		DepartmentDTO de = new DepartmentDTO();
//		DepartmentDAO departDAO = new DepartmentDAO();
//		Depar_EmpDTO de_em = new Depar_EmpDTO();
//		
//		de.setDepartment_id(60);
//		de_em = departDAO.getList(de);
//		
//		for(int i=0; i<de_em.getAr().size(); i++) {
//			System.out.println(de_em.getAr().get(i).getLast_name());
//			System.out.println(de_em.getAr().get(i).getSalary());
//			System.out.println(de_em.getAr().get(i).getHire_date());
//			System.out.println("-------------------------------");
//		}
//		System.out.println(de_em.getDepartment_name());
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(302);
		departmentDTO.setDepartment_name("Test2");
		departmentDTO.setManager_id(205);
		departmentDTO.setLocation_id(1700);
		
		int result = departmentDAO.setInsert(departmentDTO);
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		
	}

}
