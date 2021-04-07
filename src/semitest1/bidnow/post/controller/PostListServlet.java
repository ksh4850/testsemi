package semitest1.bidnow.post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import semitest1.bidnow.common.PageInfoDTO;
import semitest1.bidnow.common.page.Pagenation;
import semitest1.bidnow.post.model.dto.PostDTO;
import semitest1.bidnow.post.model.service.PostService;


@WebServlet("/post/list/l")
public class PostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lcategory = request.getParameter("lcategory");
	
		System.out.println("lcategory : " + lcategory);
		
		String currentPage = request.getParameter("currentPage");
		/*페이징 처리
		 * 1.현재 보여질 페이지를 담을 변수 선언 (현제 페이지 설정)
		 * 처음에 는 1페이지가 보여저야 하므로 1로 초기화  */
		
		int pageNo = 1;
		
		//현제 페이지에 대한 정보가 파라미터로 전달 될 경우 현재 페이지 변수를 갱신한다.
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.valueOf(currentPage);
			
			//0보다 작은 숫자가 넘어 오면 1페이지를 보여준다.
			if(pageNo <= 0 ) {
				pageNo = 1;
			}
		}
		
		/* 2. 전체 게시물 갯수 조회
		 * DB를 조회하여 게시 가능한 게시물의 총갯수를 조회*/
		PostService postService = new PostService();
		
		int totalCount = postService.selectTotalCount(lcategory);
		
		System.out.println("게시 가능한 게시물의 총 갯수 : " + totalCount );
		
		/* 3.한페이지에 보여줄 개시물수 */
		int limit = 12 ;
		
		/* 4. 한번에 보여질때 페이징 버튼 수 */
		int buttonAmount = 5 ;
		
		/* 5. 지금까지 만든 변수들르 가지고 페이징 처리를 한 후 페이징 처리에 관한 정보를 담고 있는
		 * 인스턴스를 반환 받기 (feat. Pagenation.getPageInfo()메소드 , PageInfoDTO*/
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo,totalCount,limit,buttonAmount);
	
		
		List<PostDTO> postList = null;
		
		PostDTO postDTO = new PostDTO();
		
			postList = postService.selectpostList(lcategory , pageInfo);
		
//		System.out.println(postList);
		
		
		String path = "";
		
		if(!postList.isEmpty()) {
			path="/WEB-INF/views/post/postList.jsp";
			request.setAttribute("postList", postList);
			request.setAttribute("pageInfo", pageInfo);
					
		}else {
			path="/WEB-INF/views/post/postList.jsp";
			request.setAttribute("postList", postList);
		}

		request.getRequestDispatcher(path).forward(request, response);

		
	}



}
