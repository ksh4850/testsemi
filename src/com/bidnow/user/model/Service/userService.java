package com.bidnow.user.model.Service;

import static com.bidnow.common.jdbc.JDBCTemplate.close;
import static com.bidnow.common.jdbc.JDBCTemplate.commit;
import static com.bidnow.common.jdbc.JDBCTemplate.getConnection;
import static com.bidnow.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bidnow.common.PageInfoDTO;
import com.bidnow.post.model.dto.BidDTO;
import com.bidnow.post.model.dto.ImgDTO;
import com.bidnow.post.model.dto.InquiryDTO;
import com.bidnow.post.model.dto.PostDTO;
import com.bidnow.user.model.dao.UserDAO;
import com.bidnow.user.model.dto.UserDTO;

public class userService {
	
	private final UserDAO  userDAO;
	
	public userService(){
		userDAO = new UserDAO();
	}

	public int insertUser(UserDTO user) {
		
		Connection con = getConnection(); 
		
		int result = userDAO.insertUser(con,user);
		
		
		if(result > 0){
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public UserDTO userLoginSelect(UserDTO user) {
		
		Connection con = getConnection() ; 
		UserDTO userlogin= null;
		
		
		userlogin = userDAO.userLoginSelect(con, user);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if(!passwordEncoder.matches(user.getPwd(), userlogin.getPwd())) {
			userlogin = null;
		}
		
		System.out.println(" 서비스 로그인데이터 : " + userlogin);
		close(con);
		
		return userlogin;
	}

	public int selectUserSellInfoCount(String no) {
		
		Connection con = getConnection();
		
		int totalCount = userDAO.selectUserSellInfoCount(con , no);
		
		
		close(con);
		
		return totalCount;
		
	}

	public List<PostDTO> selectUserSellInfo(String no, PageInfoDTO pageInfo) {
		
		
		
		Connection con = getConnection();
		
		List<PostDTO> postList = userDAO.selectUserSellInfo(con , no, pageInfo);
		
		for(int i = 0 ; i < postList.size() ; i ++) {
			
			List<ImgDTO> imglist = userDAO.selectUserSellInfoImgList(con, postList.get(i).getPostNo());
			
			List<BidDTO> bidList = userDAO.selectUserSellInfoMaxBidList(con, postList.get(i).getPostNo());
			
			
			
			postList.get(i).setImgList(imglist);
			postList.get(i).setBidList(bidList);
			System.out.println();
		}

		
		
		close(con);
		
		return postList;
		
		
	}

	public int selectUserPurchaseInfoCount(String no) {
		Connection con = getConnection();
		
		int totalCount = userDAO.selectUserPurchaseInfoCount(con , no);
		
		
		close(con);
		
		return totalCount;
	}

	public List<PostDTO> selectUserPurchaseInfo(String no, PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<PostDTO> postList = userDAO.selectUserPurchaseInfo(con , no, pageInfo);
		
		for(int i = 0 ; i < postList.size() ; i ++) {
			
			List<ImgDTO> imglist = userDAO.selectUserPurchaseImgList(con, postList.get(i).getPostNo());
			
			postList.get(i).setImgList(imglist);

			System.out.println();
		}

		
		
		close(con);
		
		return postList;
	}

}
