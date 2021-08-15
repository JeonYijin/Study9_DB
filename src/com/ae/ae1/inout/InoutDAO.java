package com.ae.ae1.inout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ae.ae1.bankbook.BankBookDTO;
import com.ae.ae1.util.DBConnect;

public class InoutDAO {

	private DBConnect dbConnect;
	
	public InoutDAO() {
		dbConnect = new DBConnect();
	}
	
	//거래하기
	public int trade(InoutDTO inoutDTO) {
		Connection con = null;
		PreparedStatement st = null;
		BankBookDTO bankBookDTO = new BankBookDTO();
		int result = 0;
		try {
			con = dbConnect.getConnect();
			String sql = "INSERT INTO INOUT "
					+ "VALUES(SYSDATE, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setDouble(1, inoutDTO.getTran_amount());
			st.setString(2, inoutDTO.getTran_check());
			st.setDouble(3, inoutDTO.getTran_balance()+ bankBookDTO.getBalance());
			st.setString(4, inoutDTO.getMemberDTO().getId());
			
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
