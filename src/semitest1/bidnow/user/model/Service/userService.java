package semitest1.bidnow.user.model.Service;

import static semitest1.bidnow.common.jdbc.JDBCTemplate.close;
import static semitest1.bidnow.common.jdbc.JDBCTemplate.commit;
import static semitest1.bidnow.common.jdbc.JDBCTemplate.getConnection;
import static semitest1.bidnow.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import semitest1.bidnow.user.model.dao.UserDAO;
import semitest1.bidnow.user.model.dto.UserDTO;

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

}
