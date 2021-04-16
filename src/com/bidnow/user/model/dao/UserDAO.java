package com.bidnow.user.model.dao;

import static com.bidnow.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bidnow.common.ConfigLocation;
import com.bidnow.common.PageInfoDTO;
import com.bidnow.post.model.dto.BidDTO;
import com.bidnow.post.model.dto.ImgDTO;
import com.bidnow.post.model.dto.PostDTO;
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


	public int selectUserSellInfoCount(Connection con, String no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		
		String query = prop.getProperty("selectUserSellInfoCount");
		
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, no);
			
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


	public List<PostDTO> selectUserSellInfo(Connection con, String no, PageInfoDTO pageInfo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PostDTO> postList = null;
		
		String query = prop.getProperty("selectUserSellInfo");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, no);
			pstmt.setInt(2, pageInfo.getStarRow());
			pstmt.setInt(3, pageInfo.getEndPow());
			
			rset = pstmt.executeQuery();
			
			postList = new ArrayList<>();
//			PostDTO post = null;
			while(rset.next()) {
				PostDTO	post = new PostDTO();
				post.setSeller(new UserDTO());
				
				post.setPostNo(rset.getString("POST_NO"));
				post.getSeller().setNo(rset.getString("SELLER_NO"));
				post.setPostedDate(rset.getDate("POSTED_DATE"));
				post.setTitle(rset.getString("POST_TITLE"));
				post.setDetails(rset.getString("POST_DETAILS"));
				post.setPostCheck(rset.getString("POST_CHK"));
				post.setDealingCheck(rset.getString("DEALING_CHK"));
				post.setMinPrice(rset.getInt("MIN_PRICE"));
				post.setUnOpenedchk(rset.getString("UNOPENED_CHK"));
				post.setBidEndDate(rset.getTimestamp("BID_END_DATE"));
				post.setBidStatus(rset.getString("BID_STATUS"));

				
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


	public List<ImgDTO> selectUserSellInfoImgList(Connection con, String postNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		List<ImgDTO> imgList = null;
		
		ImgDTO img = null;
		
		String query = prop.getProperty("selectUserSellInfoImgList");
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, postNo);
			
			rset = pstmt.executeQuery();
			
			imgList = new ArrayList<>();	
			
			while(rset.next()) {
				img = new ImgDTO();
				img.setFileNo(rset.getString("FILE_NO"));
				img.setPostNo(rset.getString("POST_NO"));
				img.setOrgFileName(rset.getString("ORG_FILE_NAME"));
				img.setReFileName(rset.getString("RN_FILE_NAME"));
				img.setThnFileName(rset.getString("THN_FILE_NAME"));
				
				
				imgList.add(img);

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return imgList;
		
		
	}


	public List<BidDTO> selectUserSellInfoMaxBidList(Connection con, String postNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BidDTO> bidList = null;
		
		BidDTO bid = null;
		
		String query = prop.getProperty("selectUserSellInfoMaxBidList");
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, postNo);
			pstmt.setString(2, postNo);
			
			rset = pstmt.executeQuery();
			
			bidList = new ArrayList<>();	
			
			while(rset.next()) {
				bid = new BidDTO();	
				bid.setBidNo(rset.getString("BID_NO"));
				bid.setPostNo(rset.getString("POST_NO"));
				bid.setPurchser(new UserDTO());
				bid.getPurchser().setNo(rset.getString("PURCHASER_NO"));
				bid.setBidPrice(rset.getInt("BID_PRICE"));
				bid.setBidDate(rset.getDate("BID_DATE"));
				bid.setDealingCheck(rset.getString("DEALING_CHK"));
				bid.setBidStatus(rset.getString("BID_STATUS"));
				
//				System.out.println(bid);
				bidList.add(bid);
	

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		
		return bidList;
		
		
	}


	public int selectUserPurchaseInfoCount(Connection con, String no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		
		String query = prop.getProperty("selectUserPurchaseInfoCount");
		
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, no);
			
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


	public List<PostDTO> selectUserPurchaseInfo(Connection con, String no, PageInfoDTO pageInfo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<PostDTO> postList = null;
		
		String query = prop.getProperty("selectUserPurchaseInfo");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, no);
			pstmt.setInt(2, pageInfo.getStarRow());
			pstmt.setInt(3, pageInfo.getEndPow());
			
			rset = pstmt.executeQuery();
			
			postList = new ArrayList<>();
//			PostDTO post = null;
			while(rset.next()) {
				PostDTO	post = new PostDTO();
				post.setSeller(new UserDTO());
				post.setBidList(new ArrayList<>());
				
				BidDTO bid = new BidDTO();
				
				post.setPostNo(rset.getString("POST_NO"));
				post.getSeller().setNo(rset.getString("SELLER_NO"));
				post.setPostedDate(rset.getDate("POSTED_DATE"));
				post.setTitle(rset.getString("POST_TITLE"));
				post.setDetails(rset.getString("POST_DETAILS"));
				post.setPostCheck(rset.getString("POST_CHK"));
				post.setDealingCheck(rset.getString("POST_DEALING_CHK"));
				post.setMinPrice(rset.getInt("MIN_PRICE"));
				post.setUnOpenedchk(rset.getString("UNOPENED_CHK"));
				post.setBidEndDate(rset.getTimestamp("BID_END_DATE"));
				post.setBidStatus(rset.getString("POST_BID_STATUS"));
				bid.setBidNo(rset.getString("BID_NO"));
				bid.setPurchser(new UserDTO());
				bid.getPurchser().setNo(rset.getString("PURCHASER_NO"));
				bid.setBidPrice(rset.getInt("BID_PRICE"));
				bid.setBidDate(rset.getDate("BID_DATE"));
				bid.setDealingCheck(rset.getString("DEALING_CHK"));
				bid.setBidStatus(rset.getString("BID_STATUS"));
				
				
				 post.getBidList().add(bid);
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


	public List<ImgDTO> selectUserPurchaseImgList(Connection con, String postNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		List<ImgDTO> imgList = null;
		
		ImgDTO img = null;
		
		String query = prop.getProperty("selectUserPurchaseImgList");
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, postNo);
			
			rset = pstmt.executeQuery();
			
			imgList = new ArrayList<>();	
			
			while(rset.next()) {
				img = new ImgDTO();
				img.setFileNo(rset.getString("FILE_NO"));
				img.setPostNo(rset.getString("POST_NO"));
				img.setOrgFileName(rset.getString("ORG_FILE_NAME"));
				img.setReFileName(rset.getString("RN_FILE_NAME"));
				img.setThnFileName(rset.getString("THN_FILE_NAME"));
				
				
				imgList.add(img);

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return imgList;
		
		
	}

}
