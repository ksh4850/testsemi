package com.bidnow.user.controller;

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
import com.bidnow.user.model.Service.userService;
import com.bidnow.user.model.dto.UserDTO;


@WebServlet("/user/mypage/purchaseInfo")
public class UserSelectPurchaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("잘넘어오니?");
		
		String currentPage = request.getParameter("currentPage");
		
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);
			
			if(pageNo <= 0 ) {
				pageNo = 1;
			}
		}
		
		 UserDTO user = (UserDTO) request.getSession().getAttribute("loginUser");
		 
		 int totalCount = new userService().selectUserPurchaseInfoCount(user.getNo());
			
			System.out.println(totalCount);
			
			int limit = 5 ;
			//페이징 수 
			int buttonAmount = 5 ;
			
			
			PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo,totalCount,limit,buttonAmount);
			
			
			List<PostDTO> postList = new userService().selectUserPurchaseInfo(user.getNo() , pageInfo);
			
			for(PostDTO list : postList) {
				System.out.println(list);
			}
			
				String path = "";
			
			if(!postList.isEmpty()) {
				path="/WEB-INF/views/user/PurchaseInfo.jsp";
				request.setAttribute("postList", postList);
				request.setAttribute("pageInfo", pageInfo);
				
				
						
			}else {
				path="/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "판매중목록 셀렉 실패");
			}

			request.getRequestDispatcher(path).forward(request, response);
		 
	
	}

}
