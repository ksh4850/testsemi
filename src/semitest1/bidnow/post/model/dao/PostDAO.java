package semitest1.bidnow.post.model.dao;

import static semitest1.bidnow.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import semitest1.bidnow.common.ConfigLocation;
import semitest1.bidnow.common.PageInfoDTO;
import semitest1.bidnow.post.model.dto.BidDTO;
import semitest1.bidnow.post.model.dto.CategoryDTO;
import semitest1.bidnow.post.model.dto.ImgDTO;
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
//				post.setImgRoot(rset.getString("PICTURE_ROOT"));
				post.setUnOpenedchk(rset.getString("UNOPENED_CHK"));
				post.setBidEndDate(rset.getTimestamp("BID_END_DATE"));
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
//				post.setImgRoot(rset.getString("PICTURE_ROOT"));
				post.setUnOpenedchk(rset.getString("UNOPENED_CHK"));
				post.setBidEndDate(rset.getTimestamp("BID_END_DATE"));
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
	//게시글 이미지 , 썸내일 경로 인설트
	public int inserPostImg(PostDTO postDTO, Connection con, String postNo) {

		PreparedStatement pstmt = null;
		int insertPostResult = 0;

		String query = prop.getProperty("insertPostImg");
		
		try {
			
			for(int i =0 ;i < postDTO.getImg().size() ; i++ ) {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, postNo);
			pstmt.setString(2, postDTO.getImg().get(i).getOrgFileName());
			pstmt.setString(3, postDTO.getImg().get(i).getReFileName());
			pstmt.setString(4, postDTO.getImg().get(i).getThnFileName());
			
			
			insertPostResult = pstmt.executeUpdate();
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return insertPostResult;
	}
	//게시물 인설트
	public int inserPostRegist(PostDTO postDTO, Connection con) {

		PreparedStatement pstmt = null;
		int insertPostResult = 0;
		
		String query = prop.getProperty("inserPostRegist");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, postDTO.getSeller().getNo());
			pstmt.setString(2, postDTO.getCategory().getCtgSCode());
			pstmt.setString(3, postDTO.getTitle());
			pstmt.setString(4, postDTO.getDetails());
			pstmt.setInt(5, postDTO.getMinPrice());
			pstmt.setString(6, postDTO.getUnOpenedchk());
			pstmt.setTimestamp(7, postDTO.getBidEndDate());
			
			insertPostResult =pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		
		
		
		return insertPostResult;
	}
	//이미지저장을 위한 게시물 번호 셀렉
	public String selectPostNo(Connection con, String no) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String postNo = "";
		
		String query = prop.getProperty("selectPostNo");
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				postNo = rset.getString(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		
		return postNo;
	}
	//게시물 이미지 셀렉
	public List<ImgDTO> selectPostImgList(Connection con, String no) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		List<ImgDTO> imgList = null;
		
		ImgDTO img = null;
		
		String query = prop.getProperty("selectPostImgList");
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, no);
			
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
	
	//postDtail 셀렉
	public PostDTO selectPostDtail(Connection con, String postNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PostDTO	post =null;
		
		String query = prop.getProperty("selectPostDtail");
		
		try {
			pstmt =con.prepareStatement(query);
			pstmt.setString(1, postNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				post = new PostDTO();
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
				post.setUnOpenedchk(rset.getString("UNOPENED_CHK"));
				post.setBidEndDate(rset.getTimestamp("BID_END_DATE"));
				post.setBidStatus(rset.getString("BID_STATUS"));
				post.getCategory().setCtgSCode(rset.getString("S_CTG_CODE"));
				post.getCategory().setCtgSName(rset.getString("S_CTG_NAME"));


			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		
		return post;
		
	}
	//postDtail에 이미지 셀렉
	public List<ImgDTO> selectPostDetailImgList(Connection con, String postNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ImgDTO> imgList = null;
		
		ImgDTO img = null;
		
		String query = prop.getProperty("selectPostDetailImgList");
		
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
				
//				System.out.println("img" + img);
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

	public List<BidDTO> selectPostDetailbidList(Connection con, String postNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BidDTO> bidList = null;
		
		BidDTO bid = null;
		
		String query = prop.getProperty("selectPostDetailBidList");
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, postNo);
			
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

	public int insertBid(Connection con,String postNo, String userNo, int bidPrice) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBid");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, postNo);
			pstmt.setString(2, userNo);
			pstmt.setInt(3, bidPrice);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		
		
		
		return result;
	}

	public List<BidDTO> selectAjaxBidList(Connection con, String postNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<BidDTO> bidList = null;
		
		BidDTO bid = null;
		
		String query = prop.getProperty("selectAjaxBidList");
		
		try {
			pstmt= con.prepareStatement(query);
			pstmt.setString(1, postNo);
			
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
				
				System.out.println(bid);
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

	public int insertBidCancel(Connection con, String postNo, String userNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBidCancel");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, postNo);
			pstmt.setString(2, userNo);
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		
		
		
		return result;
		
		
	}

	

}
