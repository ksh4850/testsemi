package com.bidnow.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bidnow.post.model.dto.InquiryDTO;
import com.bidnow.post.model.service.PostService;
import com.bidnow.user.model.dto.UserDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/post/updateCommentResponse")
public class PostUpdateCommentResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		System.out.println("잘넘오오니??");
		String responseDetail = request.getParameter("responseDetail");
		String inquiryNo = request.getParameter("inquiryNo");
		String postNo = request.getParameter("postNo");
		
		System.out.println(inquiryNo + " : " + responseDetail);
		InquiryDTO inquiryDTO = new InquiryDTO();
		inquiryDTO.setPostNo(postNo);
		inquiryDTO.setInquiryNo(inquiryNo);
		inquiryDTO.setResponse(responseDetail);
		
		
//		List<InquiryDTO> inquiryList = new PostService().updateCommentResponse(inquiryDTO);
//		
//		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
//		String jsonString= gson.toJson(inquiryList);
//		
//		System.out.println(jsonString);
//		
//		
//		response.setContentType("application/json; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print(jsonString);
//		
//		out.flush();
//		out.close();
	}

}
