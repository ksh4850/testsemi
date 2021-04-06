package semitest1.bidnow.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semitest1.bidnow.user.model.Service.userService;
import semitest1.bidnow.user.model.dto.UserDTO;

@WebServlet("/user/regist")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/registForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
		//web-inf 는 외부에서 접근이불가능하므로 내부에서 포워드 방식으로 이동가능함!!!
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userMobile = request.getParameter("userMobile").replace("-", ""); //String replace 메소드는 문장열 변경해주는거 !!!;
		String email = request.getParameter("email");
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1")+ "$" + request.getParameter("address2");
		
//		System.out.println("userId" + userId);
//		System.out.println("userPwd" + userPwd);
//		System.out.println("userName" + userName);
//		System.out.println("userMobile" + userMobile);
//		System.out.println("eamil" + eamil);
//		System.out.println("address" + address);
		
		UserDTO user = new UserDTO();
		user.setId(userId);
		user.setPwd(userPwd);
		user.setName(userName);
		user.setMobile(userMobile);
		user.setEmail(email);
		user.setAddress(address);
		
		System.out.println(user);
		
		int result = new userService().insertUser(user);
		
		String page ="";
		
		if(result > 0) {
			
			page = "/WEB-INF/views/common/success.jsp";
			
			request.setAttribute("successCode", "insertMember");
			
		} else {
			
			page = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "회원 가입 실패!");
		}

		request.getRequestDispatcher(page).forward(request, response);
		
		
		
		
	}

}
