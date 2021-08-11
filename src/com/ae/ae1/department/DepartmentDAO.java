package com.ae.ae1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.employee.EmployeeDTO;
import com.ae.ae1.util.DBConnect;

public class DepartmentDAO {
		
	private DBConnect dbConnect;

	public DepartmentDAO() {
		dbConnect = new DBConnect();
	}
	
	//getlist
	
	public Depar_EmpDTO getList(DepartmentDTO departmentDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depar_EmpDTO depar_emp = null;
		
		ArrayList<EmployeeDTO> ar = null;
		try {
			con = dbConnect.getConnect();
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME ");
			sb.append("FROM EMPLOYEES E INNER JOIN DEPARTMENTS D ");
			sb.append("ON E.DEPARTMENT_ID = D.DEPARTMENT_ID ");
			sb.append("WHERE E.DEPARTMENT_ID = ?");
			
			st = con.prepareStatement(sb.toString());
			st.setInt(1, departmentDTO.getDepartment_id());
			
			rs = st.executeQuery();
			depar_emp = new Depar_EmpDTO();
			depar_emp.setAr(new ArrayList<EmployeeDTO>());
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setLast_name(rs.getString("Last_name"));
				employeeDTO.setSalary(rs.getInt("Salary"));
				employeeDTO.setHire_date(rs.getDate("Hire_date"));
				depar_emp.getAr().add(employeeDTO);
				depar_emp.setDepartment_name(rs.getString("Department_name"));
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return depar_emp;
		
	}
	
	
	
}
