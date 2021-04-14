package com.bidnow.post.model.service;

import static com.bidnow.common.jdbc.JDBCTemplate.close;
import static com.bidnow.common.jdbc.JDBCTemplate.commit;
import static com.bidnow.common.jdbc.JDBCTemplate.getConnection;
import static com.bidnow.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.bidnow.common.PageInfoDTO;
import com.bidnow.post.model.dao.PostDAO;
import com.bidnow.post.model.dto.BidDTO;
import com.bidnow.post.model.dto.CategoryDTO;
import com.bidnow.post.model.dto.ImgDTO;
import com.bidnow.post.model.dto.InquiryDTO;
import com.bidnow.post.model.dto.PostDTO;

public class PostService {
	
	private PostDAO postDAO;
	
	
	public PostService(){
		postDAO = new PostDAO();
	}
	
	
	
	
	//대분류 카테고리리스트 조회
	public List<PostDTO> selectpostLaryList(String lcategory ,PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		
		
		List<PostDTO> postList = postDAO.selectpostLaryList(con , lcategory , pageInfo);
		
		for(int i = 0 ; i < postList.size() ; i ++) {
			
			List<ImgDTO> imglist = postDAO.selectPostImgList(con, postList.get(i).getNo());
			
			postList.get(i).setImg(imglist);
			
		}
		
//		for()
//		List<ImgDTO> imglist = postDAO.selectPostImgList(con, postList.ge)
		
		close(con);
		
		return postList;
	}



	//대분류 카테고리 총 게시물수 
	public int selectLaryTotalCount(String lcategory) {
		
		Connection con = getConnection();
		
		int totalCount = postDAO.selectLaryTotalCount(con , lcategory);
		
		
		close(con);
		
		return totalCount;
	}



	//소분류 카테고리 리스트
	public List<PostDTO> selectpostSmellList(String scategory, PageInfoDTO pageInfo) {
		Connection con = getConnection();
		
		List<PostDTO> postList = postDAO.selectpostSmellList(con , scategory , pageInfo);
		
		for(int i = 0 ; i < postList.size() ; i ++) {
			
			List<ImgDTO> imglist = postDAO.selectPostImgList(con, postList.get(i).getNo());
			
			postList.get(i).setImg(imglist);
			
		}
		
//		for(PostDTO tt : postList) {
//			System.out.println(tt);
//		}
		
		close(con);
		
		return postList;
	}



	//소분류 카테고리 총 게시물수 
	public int selectSmallTotalCount(String scategory) {
		
		Connection con = getConnection();
		
		int totalCount = postDAO.selectSmallTotalCount(con , scategory);
		
		
		close(con);
		
		return totalCount;
		
		
	}



	//게시물등록
	public int PostRegist(PostDTO postDTO) {
		
		Connection con = getConnection();
		
		int insetPostResult = postDAO.inserPostRegist(postDTO , con);
		int imgResult = 0;

		if(insetPostResult > 0) {
		
			String postNo = postDAO.selectPostNo(con,postDTO.getSeller().getNo());
			

			imgResult = postDAO.inserPostImg(postDTO , con ,postNo);
			
			if(imgResult == postDTO.getImg().size()) {
				commit(con);
			}else{
				rollback(con);
			}
		}
		close(con);
		
		return imgResult;
	}



	//게시물 디테일 셀렉
	public PostDTO selectPostDtail(String postNo ) {
		
		Connection con = getConnection();
		
		PostDTO postDTO = postDAO.selectPostDtail(con, postNo);
		
		List<ImgDTO> imglist = postDAO.selectPostDetailImgList(con, postNo);
		
		List<BidDTO> bidList = postDAO.selectPostDetailbidList(con, postNo);
		
		List<InquiryDTO> inquiryList = postDAO.selectPostInquiryList(con,postNo);
		
//		System.out.println(inquiryList);
		
		postDTO.setImg(imglist);
		postDTO.setBidList(bidList);
		postDTO.setInquiryList(inquiryList);
		
//		System.out.println(postDTO);
		
		
		close(con);
		
		return postDTO;
	}



	//투찰 인설트
	public int insertBid(String postNo, String userNo, int bidPrice) {

		Connection con = getConnection();
		
		int result = postDAO.insertBid(con ,postNo,userNo,bidPrice);
		
		
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}



	//비드리스트 셀렉
	public List<BidDTO> selectAjaxBidList(String postNo) {

		Connection con = getConnection();
		
		List<BidDTO> bidList = postDAO.selectAjaxBidList(con, postNo);
		
		close(con);
		
		return bidList;
	}



	//투찰 취소 업데이트
	public int insertBidCancel(String postNo, String userNo) {

		Connection con = getConnection();
		
		int result = postDAO.insertBidCancel(con ,postNo,userNo);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
		
	
	}




	public List<CategoryDTO> selectSCategoryList(String lcategory) {
		
		Connection con = getConnection();
		
		List<CategoryDTO> categortList = postDAO.selectSCategoryList(con ,lcategory);
		
		close(con);
		
		return categortList;
	}




	public PostDTO selectUpdatePostDtail(String postNo) {
		
		Connection con = getConnection();
		
		PostDTO postDTO = postDAO.selectUpdatePostDtail(con, postNo);
		
		
		return postDTO;
	}




	public List<InquiryDTO> insertComment(InquiryDTO inquiryDTO) {

		Connection con = getConnection();
		
		List<InquiryDTO> inquiryList = null;
		
		int result = postDAO.insertComment(con , inquiryDTO);
		
		if(result > 0) {
			inquiryList =  postDAO.aJaxInquiryList(con , inquiryDTO.getPostNo());
//			
			if(!inquiryList.isEmpty()) {
				commit(con);
			}else {
				rollback(con);
			}
		}
	
		
		
		close(con);
		
		return inquiryList;
	}




	public List<InquiryDTO> updateCommentResponse(InquiryDTO inquiryDTO) {
		
		Connection con = getConnection();
		
		List<InquiryDTO> inquiryList = null;
		
		int result = postDAO.updateCommentResponse(con , inquiryDTO);
		
		if(result > 0) {
			inquiryList =  postDAO.aJaxInquiryList(con , inquiryDTO.getPostNo());
			
			if(!inquiryList.isEmpty()) {
				commit(con);
			}else {
				rollback(con);
			}
		}
	
		
		
		close(con);
		
		return inquiryList;
		
		
	}

}
