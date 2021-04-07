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
	public List<PostDTO> selectpostList(String lcategory ,PageInfoDTO pageInfo) {

		Connection con = getConnection();
		
		List<PostDTO> postList = postDAO.selectpostList(con , lcategory , pageInfo);
		
		close(con);
		
		return postList;
	}




	public int selectTotalCount(String lcategory) {
		
		Connection con = getConnection();
		
		int totalCount = postDAO.selectTotalCount(con , lcategory);
		
		
		close(con);
		
		return totalCount;
	}

}
