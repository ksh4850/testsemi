package com.bidnow.post.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post/updateCommentResponse")
public class PostUpdateCommentResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		System.out.println("잘넘오오니??");
		String responseDetail = request.getParameter("responseDetail");
		String purchaserNo = request.getParameter("purchaserNo");
		String postNo = request.getParameter("postNo");
		
		System.out.println(purchaserNo + " : " + responseDetail + " : " + postNo );
	}

}
