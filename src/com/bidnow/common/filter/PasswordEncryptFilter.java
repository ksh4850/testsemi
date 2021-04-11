package com.bidnow.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.bidnow.common.wrapper.EncrypeRequestWrapper;


@WebFilter("/user/*")
public class PasswordEncryptFilter implements Filter {

    

	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		
		String uri = hrequest.getRequestURI();
		/* http://localhost:8080/project/list.jsp
		 * /project/list.jsp  프로젝트 + 파일경로까지 가져옵니다
		 * */
		
//		System.out.println(uri);
		
		String intent = uri.substring(uri.lastIndexOf("/"));
		/* substring(index)문자열을 잘라주는 메소드
		 * lastIndexOf(문자) 뒤에서부터 특정 문자의 위치 인덱스로 반환*/
//		System.out.println(intent);
		
		if(!intent.equals("/login")) {
			EncrypeRequestWrapper wrapper = new EncrypeRequestWrapper(hrequest);
			//HttpServletRequestWrapper에서 부모의 get파라미터를 재정의해서 필터를통해서 서블릿이 실행전에 로그인할때가 아니면 비번을 암호화한다.
			chain.doFilter(wrapper, response);
		}else {
			chain.doFilter(request, response);
		}

		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
