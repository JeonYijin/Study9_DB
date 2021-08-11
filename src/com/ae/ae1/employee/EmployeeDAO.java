package com.ae.ae1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ae.ae1.department.DepartmentDTO;
import com.ae.ae1.util.DBConnect;

public class EmployeeDAO {

	private DBConnect dbConnect;
	
	public EmployeeDAO() {
		dbConnect = new DBConnect();
	}
	
	//getJoin
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Emp_DepartDTO emp_departDTO = null;
		DepartmentDTO departmentDTO = null;
		try {
			con = dbConnect.getConnect();
			//StringBuffer 사용해보기
			
			String sql = "SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME "
					+ "FROM EMPLOYEES E INNER JOIN DEPARTMENTS D "
					+ "ON E.DEPARTMENT_ID = D.DEPARTMENT_ID "
					+ "WHERE E.EMPLOYEE_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, employeeDTO.getEmployee_id());
			rs = st.executeQuery();
			
			if(rs.next()) {
				emp_departDTO = new Emp_DepartDTO();
				departmentDTO = new DepartmentDTO();
				emp_departDTO.setLast_name(rs.getString(1));
				emp_departDTO.setSalary(rs.getInt(2));
				emp_departDTO.setHire_date(rs.getDate(3));
				departmentDTO.setDepartment_name(rs.getString(4));
				emp_departDTO.setDepartmentDTO(departmentDTO);
				//emp_departDTO.setDepartmentDTO(new DepartmentDTO());
				//emp_departDTO.getDepartmentDTO().setDepartment_name(rs.getString(4));
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
		
		return emp_departDTO;
		
		
	}
	
	
	
	//1. 전체사원 출력
	public ArrayList<EmployeeDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		
		try {
			con = dbConnect.getConnect();
		//sql
			String sql = "SELECT * FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				employeeDTO = new EmployeeDTO();
				
				employeeDTO.setEmployee_id(rs.getInt(1));
				employeeDTO.setFirst_name(rs.getString(2));
				employeeDTO.setLast_name(rs.getString(3));
				employeeDTO.setEmail(rs.getString(4));
				employeeDTO.setPhone_number(rs.getString(5)); 
				employeeDTO.setHire_date(rs.getDate(6));
				employeeDTO.setJob_id(rs.getString(7));
				employeeDTO.setSalary(rs.getInt(8));
				employeeDTO.setCommission_pct(rs.getDouble(9));
				employeeDTO.setManager_id(rs.getInt(10));
				employeeDTO.setDepartment_id(rs.getInt(11));
				
				ar.add(employeeDTO);
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
		return ar;
		
	}
	
	
	//2. 사원번호 입력해서 한 사원의 정보 출력
	
	public EmployeeDTO getOne(int num) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		
		try {
			con = dbConnect.getConnect();
			String sql = "select * from employees where employee_id = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			rs = st.executeQuery();
			if(rs.next()) {
				employeeDTO = new EmployeeDTO();
				
				employeeDTO.setEmployee_id(rs.getInt(1));
				employeeDTO.setFirst_name(rs.getString(2));
				employeeDTO.setLast_name(rs.getString(3));
				employeeDTO.setEmail(rs.getString(4));
				employeeDTO.setPhone_number(rs.getString(5)); 
				employeeDTO.setHire_date(rs.getDate(6));
				employeeDTO.setJob_id(rs.getString(7));
				employeeDTO.setSalary(rs.getInt(8));
				employeeDTO.setCommission_pct(rs.getDouble(9));
				employeeDTO.setManager_id(rs.getInt(10));
				employeeDTO.setDepartment_id(rs.getInt(11));
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
		return employeeDTO;

	}
	
	
	//3. Last_name을 검색해서 정보 출력
	
	public ArrayList<EmployeeDTO> getLast(String last) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "select * from employees where LAST_NAME LIKE '%'||?||'%'";
			st = con.prepareStatement(sql);
			st.setString(1, last);
			rs = st.executeQuery();
			
			while(rs.next()) {
				employeeDTO = new EmployeeDTO();
				
				employeeDTO.setEmployee_id(rs.getInt(1));
				employeeDTO.setFirst_name(rs.getString(2));
				employeeDTO.setLast_name(rs.getString(3));
				employeeDTO.setEmail(rs.getString(4));
				employeeDTO.setPhone_number(rs.getString(5)); 
				employeeDTO.setHire_date(rs.getDate(6));
				employeeDTO.setJob_id(rs.getString(7));
				employeeDTO.setSalary(rs.getInt(8));
				employeeDTO.setCommission_pct(rs.getDouble(9));
				employeeDTO.setManager_id(rs.getInt(10));
				employeeDTO.setDepartment_id(rs.getInt(11));
				ar.add(employeeDTO);
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
		return ar;
		
	}
	
	//4. first_name을 검색해서 정보 출력

	public ArrayList<EmployeeDTO> getFirst(String first) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "select * from employees where FIRST_NAME LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1, "%"+first+"%");
			
			rs = st.executeQuery();
			while(rs.next()) {
				employeeDTO = new EmployeeDTO();
				
				employeeDTO.setEmployee_id(rs.getInt(1));
				employeeDTO.setFirst_name(rs.getString(2));
				employeeDTO.setLast_name(rs.getString(3));
				employeeDTO.setEmail(rs.getString(4));
				employeeDTO.setPhone_number(rs.getString(5)); 
				employeeDTO.setHire_date(rs.getDate(6));
				employeeDTO.setJob_id(rs.getString(7));
				employeeDTO.setSalary(rs.getInt(8));
				employeeDTO.setCommission_pct(rs.getDouble(9));
				employeeDTO.setManager_id(rs.getInt(10));
				employeeDTO.setDepartment_id(rs.getInt(11));
				ar.add(employeeDTO);
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
		return ar;
	}

	
	//5-1. 전체 평균 급여의 정보를 출력 - 여러 개
	public double getAvg() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmployeeDTO employeeDTO = null;
		double avg =0;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT AVG(SALARY) AS SAL FROM EMPLOYEES";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			 rs.next();
			 avg = rs.getDouble("SAL");
			 
			 
			
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
		
		return avg;
	}
	
	//5.2 부서별 평균 급여의 정보를 출력 - 부서 수 만큼
	
	public ArrayList<Double> getDpAvg() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<Double> d = new ArrayList<>();
		double avg1 = 0;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				 avg1 = rs.getDouble(1);
				 d.add(avg1);
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
		return d;
		
	}
	// 부서명과 부서별 평균 급여를 받기
	public void getDPAVG(){
		//map도 활용 가능 - 리턴 가능
		HashMap<String, Object> hashmap = new HashMap<>();
		
		hashmap.put("id", 20);
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		
	}
	
	
	
}
