package com.bidnow.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bidnow.common.PageInfoDTO;
import com.bidnow.common.page.Pagenation;
import com.bidnow.post.model.dto.PostDTO;
import com.bidnow.post.model.service.PostService;


@WebServlet("/post/list")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//카테고리 코드 전송
		String lcategory = request.getParameter("lcategory");
		String scategory = request.getParameter("scategory");
		String thumbnailLocation = request.getServletContext().getRealPath("/") + "resources/thumbnail-image";
	
//		System.out.println("lcategory : " + lcategory);
//		System.out.println("scategory : " + scategory);
		
		
		//전에 페이지 수 
		String currentPage = request.getParameter("currentPage");
		
//		System.out.println("currentPage"+currentPage);
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);
			
			if(pageNo <= 0 ) {
				pageNo = 1;
			}
		}
		
		int totalCount = 0;
		
		PostService postService = new PostService();
		
		//대분류 소분류 카테고리리 게시물수 구분
		if(lcategory != null && !"".equals(lcategory)) {
			
			totalCount = postService.selectLaryTotalCount(lcategory);
			
			
		}
		
		if(scategory != null && !"".equals(scategory)) {
			
			totalCount = postService.selectSmallTotalCount(scategory);
		}
		
//		System.out.println("게시 가능한 게시물의 총 갯수 : " + totalCount );
		
		//한페이지에 보일 게시물수
		int limit = 12 ;
		//페이징 수 
		int buttonAmount = 5 ;
		
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo,totalCount,limit,buttonAmount);
	
		
		List<PostDTO> postList = null;
		
		
		//대분류 소분류 카데고리 리스트 구분
		if(lcategory != null && !"".equals(lcategory)) {
		
			postList = postService.selectpostLaryList(lcategory , pageInfo);
		}
		
		if(scategory != null && !"".equals(scategory)) {
			postList = postService.selectpostSmellList(scategory , pageInfo);
		}
//		System.out.println(postList);
		
		
		String path = "";
		
		if(!postList.isEmpty()) {
			path="/WEB-INF/views/post/postList.jsp";
			request.setAttribute("postList", postList);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("thumbnailLocation", thumbnailLocation);
			
					
		}else {
			path="/WEB-INF/views/post/postList.jsp";
//			request.setAttribute("postList", postList);
		}

		request.getRequestDispatcher(path).forward(request, response);

		
	}



}
