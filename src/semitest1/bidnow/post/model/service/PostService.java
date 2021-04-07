package semitest1.bidnow.post.model.service;

import static semitest1.bidnow.common.jdbc.JDBCTemplate.close;
import static semitest1.bidnow.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import semitest1.bidnow.common.PageInfoDTO;
import semitest1.bidnow.post.model.dao.PostDAO;
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

}