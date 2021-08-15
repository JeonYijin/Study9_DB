package com.ae.ae1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.util.DBConnect;

public class MemberDAO {
	
	private DBConnect dbConnect;
	
	public MemberDAO() {
		dbConnect = new DBConnect();
	}
	
	//1. 모든 회원 조회
	public ArrayList<MemberDTO> getList() {
		
		Connection con =null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		MemberDTO memberDTO = null;
		try {
			con = dbConnect.getConnect();
			System.out.println(con);
			String sql = "SELECT * FROM MEMBER";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPw(rs.getInt("PW"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setPhone(rs.getString("phone"));
				memberDTO.setEmail(rs.getString("email"));
				
				ar.add(memberDTO);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return ar;
		
	}
	
	
	//2. 선택한 회원 조회
	
	public MemberDTO getOne(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM MEMBER WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			rs= st.executeQuery();
			
			if(rs.next()) {
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPw(rs.getInt("PW"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setPhone(rs.getString("phone"));
				memberDTO.setEmail(rs.getString("email"));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return memberDTO;
		
	}
	
	
	//3. 회원 가입 - 삽입
	
	public int setMember(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = dbConnect.getConnect();
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?)";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setInt(2, memberDTO.getPw());
			st.setString(3, memberDTO.getName());
			st.setString(4, memberDTO.getPhone());
			st.setString(5, memberDTO.getEmail());
			
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
	
	//4. 회원 탈퇴 - 삭제
	
	public int delete(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0; 
		
		try {
			con = dbConnect.getConnect();
			String sql = "DELETE MEMBER WHERE ID = ?";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
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
