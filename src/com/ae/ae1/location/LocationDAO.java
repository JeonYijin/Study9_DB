package com.ae.ae1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.util.DBConnect;

public class LocationDAO {
	
	private DBConnect dbConncet;
	
	public LocationDAO() {
		dbConncet = new DBConnect();
		
	}
	
	//getCount
	//location의 주소 갯수를 리턴하고 출력
	
	public int getCount() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con =dbConncet.getConnect();
			String sql = "SELECT COUNT(STREET_ADDRESS) as count FROM LOCATIONS";
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			
			count = rs.getInt("count");
			
			
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
		
		return count;
		
	}
	

	
	//getSearch
	//주소의 일부를 받아서 검색 찾은 것들을 출력
	
	public ArrayList<LocationDTO> getSearch(String address) {
		
		ArrayList<LocationDTO> ar = new ArrayList<>();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		LocationDTO locationDTO = null;
		try {
			con = dbConncet.getConnect();
			
			
			String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
			st = con.prepareStatement(sql);
			st.setString(1, "%"+address+"%"); // '%'|| ? ||'%'이렇게하면 바로 sql문에 가능
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				locationDTO = new LocationDTO();
				
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				
				ar.add(locationDTO);
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
	
	
	
	
	public LocationDTO getOne(int location_id) {
		
		//ADD-DTO Branch
		LocationDTO locationDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs= null;
	//db 연결하기
		try {
			con = dbConncet.getConnect();
			System.out.println("연결성공");
		//SQL문 작성
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			st = con.prepareStatement(sql);
		//? 값 받기
			st.setInt(1, location_id);
		//최종 전송 후 결과 처리
			rs= st.executeQuery();
			if(rs.next()) {
				//getString(컬럼명) <- 컬럼명은 데이터베이스 테이블의 컬럼명이 아니라 조회된 컬럼명임
				//별칭으로 바꾸었을 때는 별칭으로 입력해야 함 조회된 테이블 컬럼명만 확인가능
				locationDTO = new LocationDTO();
				
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
				
			}else {
				System.out.println("없는 번호");
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

		return locationDTO;
		
	}
	

	
	
	public  ArrayList<LocationDTO> getList() {
		//LOCATIONS Table을 조회해서 출력
		//1. 로그인 정보 적기, 드라이버로딩, 커넥션 객체 만들고, sql문 만들고, 최종결과 전송하고 처리하기
		
		System.out.println("location 시작");
		
	//1. 로그인 정보 입력

		ArrayList<LocationDTO> ar = new ArrayList<>();
		LocationDTO locationDTO = null;
		ResultSet rs = null;
		PreparedStatement pr = null;
		Connection con = null;
		
		try {
			//Class.forName(driver); // 안써도 됨
			//System.out.println("driver 성공");
		//3. DB Connection
			con = dbConncet.getConnect();
			System.out.println("접속성공");
			System.out.println(con);
		//4. SQL문 생성
			String sql = "SELECT * FROM LOCATIONS";
		//5. 미리 전송
			pr = con.prepareStatement(sql);
		//6. 최종 전송 후 결과 처리
			rs = pr.executeQuery();
			
			while(rs.next()) {
				locationDTO = new LocationDTO();
				
				locationDTO.setLocation_id(rs.getInt("LOCATION_ID"));
				locationDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
				locationDTO.setPostal_code(rs.getString("POSTAL_CODE"));
				locationDTO.setCity(rs.getString("CITY"));
				locationDTO.setState_province(rs.getString("STATE_PROVINCE"));
				locationDTO.setCountry_id(rs.getString("COUNTRY_ID"));
					
				ar.add(locationDTO);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pr.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return ar;
		
	}
	
	
	
	
	
	
	
	
}
