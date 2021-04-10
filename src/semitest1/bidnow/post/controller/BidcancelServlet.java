package semitest1.bidnow.post.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import semitest1.bidnow.post.model.dto.BidDTO;
import semitest1.bidnow.post.model.service.PostService;

/**
 * Servlet implementation class BidcancelServlet
 */
@WebServlet("/bid/cancel")
public class BidcancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String postNo = request.getParameter("postNo");
		String userNo = request.getParameter("userNo");
	
		List<BidDTO> bidList = null;
		int result = new PostService().insertBidCancel(postNo,userNo);
//		
		if(result > 0) {
			bidList = new PostService().selectAjaxBidList(postNo);
		}else {
			String path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 가입 실패!");
			request.getRequestDispatcher(path).forward(request, response);

		}
		
			System.out.println(bidList);
			String gson = new Gson().toJson(bidList);

			
			
		System.out.println("gson 변환 : "+gson);
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(gson);
		

		
		out.flush();
		out.close();
	}

}
