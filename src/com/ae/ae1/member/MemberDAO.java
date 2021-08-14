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
	
	
	
	
}
