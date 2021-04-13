package com.bidnow.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bidnow.post.model.dto.BidDTO;
import com.bidnow.post.model.dto.PostDTO;
import com.bidnow.post.model.service.PostService;
import com.bidnow.user.model.dto.UserDTO;


@WebServlet("/post/detail")
public class PostDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String postNo = request.getParameter("postNo");
//		System.out.println(postNo);
		
		
		
		PostDTO postDTO = new PostService().selectPostDtail(postNo);
		
		BidDTO userBidInfo = null;
		
		UserDTO user = (UserDTO)request.getSession().getAttribute("loginUser");
		
		String purchaserNo = "";
		
		
		if(user != null) {
		purchaserNo = user.getNo();
		
			for(int i = 0 ; i < postDTO.getBidList().size() ; i++) {
				 BidDTO bid = postDTO.getBidList().get(i);
				
				if( bid.getPurchser().getNo().equals(purchaserNo)){
					userBidInfo = bid;
				}
				
			}
			
		}

		
		String path ="";
		
		if(postDTO != null) {
			
//			if(postUser.isEmpty()) {
			path="/WEB-INF/views/post/postview.jsp";
			request.setAttribute("postDTO", postDTO);
			request.setAttribute("userBidInfo", userBidInfo);
			
//			}else {
//				path="/WEB-INF/views/post/postview2.jsp";
//				request.setAttribute("postDTO", postDTO);
//			}
			
					
		}else {
			path = "/WEB-INF/views/common/failed.jsp";
			
			request.setAttribute("message", "게시물 조회 실패!");
		}

		
		request.getRequestDispatcher(path).forward(request, response);
		 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
