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

@WebServlet("/post/insertComment")
public class PostCommentRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("잘넘어");
		
		String postNo = request.getParameter("postNo");
		String userNo = request.getParameter("userNo");
		String Detail = request.getParameter("Detail");
		String Secret = request.getParameter("Secret");
		
		System.out.println(postNo + " : " + userNo + " : " +Detail + " : " +Secret);
		
		InquiryDTO inquiryDTO = new InquiryDTO();
		inquiryDTO.setPostNo(postNo);
		inquiryDTO.setPurchaser(new UserDTO());
		inquiryDTO.getPurchaser().setNo(userNo);
		inquiryDTO.setInquiryDetails(Detail);
		inquiryDTO.setSecretStatus(Secret);
		
		List<InquiryDTO> inquiryList = new PostService().insertComment(inquiryDTO);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		String jsonString= gson.toJson(inquiryList);
		
		System.out.println(jsonString);
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		
		out.flush();
		out.close();
	}

}
