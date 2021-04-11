package com.bidnow.post.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bidnow.post.model.dto.PostDTO;
import com.bidnow.post.model.service.PostService;

/**
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/post/update")
public class PostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postNo = request.getParameter("postNo");
		System.out.println(postNo);
		
		
		PostDTO postDTO = new PostService().selectUpdatePostDtail(postNo);
		
		System.out.println(postDTO);
		String path="";
		if(postDTO != null) {
			
			path = "/WEB-INF/views/post/postUpdate.jsp";
			
			request.setAttribute("postDTO", postDTO);
			
			
			
		} else {
			
			path = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "게시물 수정 뷰실패!");
		}

		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
