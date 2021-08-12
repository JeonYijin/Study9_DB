package com.ae.ae1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.util.DBConnect;

public class LocationDAO {
	
	private DBConnect dbConnect;
	
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	//1. 모든 정보 list
	public ArrayList<LocationDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		ArrayList<LocationDTO> ar = new ArrayList<>();
		LocationDTO locationDTO  = null;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID DESC";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("Location_id"));
				locationDTO.setStreet_address(rs.getString("Street_address"));
				locationDTO.setPostal_code(rs.getString("Postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province("State_province");
				locationDTO.setCountry_id(rs.getString("country_id"));
				ar.add(locationDTO);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return ar;

	
	}
	
	
	//2. id 받아서 해당 location 정보 출력 - 1개
	public LocationDTO getOne(LocationDTO locationDTO){
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO result = null;
		try {
			con = dbConnect.getConnect();
			System.out.println(con);
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID =?";
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			rs = st.executeQuery();
			
			if(rs.next()) {
//				System.out.println(rs.getInt(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println(rs.getString(4));
//				System.out.println(rs.getString(5));
//				System.out.println(rs.getString(6));
				result = new LocationDTO();
				result.setLocation_id(rs.getInt("Location_id"));
				result.setStreet_address(rs.getString("Street_address"));
				result.setPostal_code(rs.getString("postal_code"));
				result.setCity(rs.getString("city"));
				result.setState_province("State_province");
				result.setCountry_id("Country_id");
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
			
		}

		return result;
		
	}
	
	//3. 지역 정보 추가
	public int setLocation(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = dbConnect.getConnect();
			String sql = "INSERT INTO LOCATIONS VALUES(?,?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			st.setString(2, locationDTO.getStreet_address());
			st.setString(3, locationDTO.getPostal_code());
			st.setString(4, locationDTO.getCity());
			st.setString(5, locationDTO.getState_province());
			st.setString(6, locationDTO.getCountry_id());
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	//4. 지역 정보 삭제
	public int delete(LocationDTO locationDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result =0;
		try {
			con = dbConnect.getConnect();
			String sql = "DELETE LOCATIONS WHERE LOCATION_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, locationDTO.getLocation_id());
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
		
	}
	
	
	
	
	
	
	
}
