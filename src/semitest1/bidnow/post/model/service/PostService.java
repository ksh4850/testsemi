package semitest1.bidnow.post.model.service;

import static semitest1.bidnow.common.jdbc.JDBCTemplate.close;
import static semitest1.bidnow.common.jdbc.JDBCTemplate.commit;
import static semitest1.bidnow.common.jdbc.JDBCTemplate.getConnection;
import static semitest1.bidnow.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import semitest1.bidnow.common.PageInfoDTO;
import semitest1.bidnow.post.model.dao.PostDAO;
import semitest1.bidnow.post.model.dto.ImgDTO;
import semitest1.bidnow.post.model.dto.PostDTO;

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




	public int PostRegist(PostDTO postDTO) {
		
		Connection con = getConnection();
		
		int insetPostResult = postDAO.inserPostRegist(postDTO , con);
		int imgResult = 0;
//		System.out.println("insetPostResult :" + insetPostResult);
		if(insetPostResult > 0) {
		
			String postNo = postDAO.selectPostNo(con,postDTO.getSeller().getNo());
			
//			System.out.println("postNo : " + postNo);
			imgResult = postDAO.inserPostImg(postDTO , con ,postNo);
			
			if(imgResult > 0) {
				commit(con);
			}else{
				rollback(con);
			}
		}
		close(con);
		
		return imgResult;
	}

}
