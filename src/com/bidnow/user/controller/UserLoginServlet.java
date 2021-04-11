package com.bidnow.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bidnow.user.model.Service.userService;
import com.bidnow.user.model.dto.UserDTO;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/user/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path ="/WEB-INF/views/user/login.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		
//		System.out.println("userpwd :" + userpwd);
//		System.out.println("userId :" + userId);
		
		UserDTO user = new UserDTO();
		user.setId(userId);
		user.setPwd(userpwd);
		
		UserDTO loginUser = new userService().userLoginSelect(user);
		
		String path = "";
		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			

			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "login");
			
			
		}else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "로그인실패");
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
