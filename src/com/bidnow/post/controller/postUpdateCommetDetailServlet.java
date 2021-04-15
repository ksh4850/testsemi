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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/post/updatecommetDetail")
public class postUpdateCommetDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inquiryNo = request.getParameter("inquiryNo");
		String postNo = request.getParameter("postNo");
		String updateDetail = request.getParameter("updateDetail");
		
		System.out.println(inquiryNo + " : " + postNo + " : " +updateDetail);
		

		InquiryDTO inquiryDTO = new InquiryDTO();
		inquiryDTO.setPostNo(postNo);
		inquiryDTO.setInquiryNo(inquiryNo);
		inquiryDTO.setInquiryDetails(updateDetail);
		
		
		List<InquiryDTO> inquiryList = new PostService().updateCommetDetail(inquiryDTO);
		
//		for(InquiryDTO i :inquiryList) {
//			System.out.println("list"+i);
//		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		String jsonString= gson.toJson(inquiryList);
		
//		System.out.println(jsonString);
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		
		out.flush();
		out.close();
	
		
	}

}
