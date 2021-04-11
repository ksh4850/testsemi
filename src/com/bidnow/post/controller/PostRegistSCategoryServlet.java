package com.bidnow.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.bidnow.post.model.dto.CategoryDTO;
import com.bidnow.post.model.service.PostService;

@WebServlet("/post/regist/scategory")
public class PostRegistSCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String lcategory = request.getParameter("lcategory");
		
		
		List<CategoryDTO> categoryList = new PostService().selectSCategoryList(lcategory);
		
		String gson = new Gson().toJson(categoryList);

		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(gson);
		

		
		out.flush();
		out.close();
		
		
		
		
	}

}
