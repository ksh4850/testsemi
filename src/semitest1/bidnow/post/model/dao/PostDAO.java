package semitest1.bidnow.post.model.dao;

import static semitest1.bidnow.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import semitest1.bidnow.common.ConfigLocation;
import semitest1.bidnow.common.PageInfoDTO;
import semitest1.bidnow.post.model.dto.CategoryDTO;
import semitest1.bidnow.post.model.dto.PostDTO;
import semitest1.bidnow.user.model.dto.UserDTO;

public class PostDAO {

	private Properties prop;

	public PostDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "post/post-mapper.xml"));
			System.out.println("mapper location : " + ConfigLocation.MAPPER_LOCATION + "post/post-mapper.xml" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//대분류 게시글 조회!!
	public List<PostDTO> selectpostLaryList(Connection con, String lcategory, PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PostDTO> postList = null;
		
		String query = prop.getProperty("selectpostLaryList");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, lcategory);
			pstmt.setInt(2, pageInfo.getStarRow());
			pstmt.setInt(3, pageInfo.getEndPow());
			
			rset = pstmt.executeQuery();
			
			postList = new ArrayList<>();
//			PostDTO post = null;
			while(rset.next()) {
				PostDTO	post = new PostDTO();
				post.setSeller(new UserDTO());
				post.setCategory(new CategoryDTO());
				
				post.setNo(rset.getString("POST_NO"));
				post.getSeller().setNo(rset.getString("SELLER_NO"));
				post.setPostedDate(rset.getDate("POSTED_DATE"));
				post.setTitle(rset.getString("POST_TITLE"));
				post.setDetails(rset.getString("POST_DETAILS"));
				post.setPostCheck(rset.getString("POST_CHK"));
				post.setDealingCheck(rset.getString("DEALING_CHK"));
				post.setMinPrice(rset.getInt("MIN_PRICE"));
				post.setImgRoot(rset.getString("PICTURE_ROOT"));
				post.setUnOpenedchk(rset.getString("UNOPENED_CHK"));
				post.setBidEndDate(rset.getDate("BID_END_DATE"));
				post.setBidStatus(rset.getString("BID_STATUS"));
				post.getCategory().setCtgLCode(rset.getString("L_CTG_CODE"));
				post.getCategory().setCtgLName(rset.getString("L_CTG_NAME"));

				
				 postList.add(post);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
//		System.out.println(postList.toString());
				
		
		return postList;
	}
	//대분류 카운터
	public int selectLaryTotalCount(Connection con, String lcategory) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		
		String query = prop.getProperty("selectLaryTotalCount");
		
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, lcategory);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				totalCount = rset.getInt(1);
				System.out.println("totalCount" + totalCount);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return totalCount;
	}
	//소분류 게시물 조회
	public List<PostDTO> selectpostSmellList(Connection con, String scategory, PageInfoDTO pageInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PostDTO> postList = null;
		
		String query = prop.getProperty("selectpostSmallList");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, scategory);
			pstmt.setInt(2, pageInfo.getStarRow());
			pstmt.setInt(3, pageInfo.getEndPow());
			
			rset = pstmt.executeQuery();
			
			postList = new ArrayList<>();
//			PostDTO post = null;
			while(rset.next()) {
				PostDTO	post = new PostDTO();
				post.setSeller(new UserDTO());
				post.setCategory(new CategoryDTO());
				
				post.setNo(rset.getString("POST_NO"));
				post.getSeller().setNo(rset.getString("SELLER_NO"));
				post.setPostedDate(rset.getDate("POSTED_DATE"));
				post.setTitle(rset.getString("POST_TITLE"));
				post.setDetails(rset.getString("POST_DETAILS"));
				post.setPostCheck(rset.getString("POST_CHK"));
				post.setDealingCheck(rset.getString("DEALING_CHK"));
				post.setMinPrice(rset.getInt("MIN_PRICE"));
				post.setImgRoot(rset.getString("PICTURE_ROOT"));
				post.setUnOpenedchk(rset.getString("UNOPENED_CHK"));
				post.setBidEndDate(rset.getDate("BID_END_DATE"));
				post.setBidStatus(rset.getString("BID_STATUS"));
				post.getCategory().setCtgSCode(rset.getString("S_CTG_CODE"));
				post.getCategory().setCtgSName(rset.getString("S_CTG_NAME"));

				
				 postList.add(post);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		

				
		
		return postList;
		
	}
	
	//소분류 카운터
	public int selectSmallTotalCount(Connection con, String lcategory) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		
		String query = prop.getProperty("selectSmallTotalCount");
		
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, lcategory);
			
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				totalCount = rset.getInt(1);
				System.out.println("totalCount" + totalCount);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return totalCount;
	}

	

}
