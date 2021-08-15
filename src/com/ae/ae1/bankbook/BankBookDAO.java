package com.ae.ae1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ae.ae1.member.MemberDTO;
import com.ae.ae1.util.DBConnect;

public class BankBookDAO {

	private DBConnect dbConnect;
	
	public BankBookDAO() {
		dbConnect = new DBConnect();
	}
	// 아이디와 일치하는 통장 조회
	public BankBookDTO getOne(BankBookDTO bankDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		MemberDTO memberDTO = null;
		BankBookDTO bankDTO2 = null;
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM BANKBOOK WHERE ID = ?";
			st= con.prepareStatement(sql);
			st.setString(1, bankDTO.getMemberDTO().getId());
			rs = st.executeQuery();
			
			if(rs.next()) {
				bankDTO2 = new BankBookDTO();
				bankDTO2.setIssue_date(rs.getDate(1));
				bankDTO2.setPro_name(rs.getString(2));
				bankDTO2.setAccount(rs.getString(3));
				bankDTO2.setBalance(rs.getDouble(4));
				bankDTO2.setMemberDTO(new MemberDTO());
				bankDTO2.getMemberDTO().setId(rs.getString(5));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		return bankDTO2;
	}
	
	
}
