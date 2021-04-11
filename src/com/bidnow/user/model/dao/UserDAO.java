package com.bidnow.user.model.dao;

import static com.bidnow.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.bidnow.common.ConfigLocation;
import com.bidnow.user.model.dto.UserDTO;

public class UserDAO {
	
	private Properties prop ;
	
	public UserDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "/user/user-mapper.xml"));
			
			System.out.println("mapper location :" + ConfigLocation.MAPPER_LOCATION + "/user/user-mapper.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public int insertUser(Connection con, UserDTO user) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertUser");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getMobile());
			pstmt.setString(6, user.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		
		return result;
	}


	public UserDTO userLoginSelect(Connection con, UserDTO user) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("userLoginSelect");
		
		UserDTO  userlogin = null;
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, user.getId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userlogin = new UserDTO();
				
				userlogin.setNo(rset.getString("USER_NO"));
				userlogin.setId(rset.getString("ID"));
				userlogin.setPwd(rset.getString("PWD"));
				userlogin.setName(rset.getString("NAME"));
				userlogin.setAddress(rset.getString("ADDRESS"));
				userlogin.setMobile(rset.getString("MOBILE"));
				userlogin.setEmail(rset.getString("EMAIL"));
				userlogin.setRegist_day(rset.getDate("REGST_DAY"));
				userlogin.setLvName(rset.getString("LV_NAME"));
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return userlogin;
	}

}
