package semitest1.bidnow.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
//	private String encodingType; 


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest)request;
		
		if("POST".equals(hrequest.getMethod())) {
			
			hrequest.setCharacterEncoding(request.getServletContext().getInitParameter("encoding"));
			
			System.out.println("post encoding : " + request.getCharacterEncoding());
			
		}
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
//		encodingType = fConfig.getInitParameter("encoding");
	}

}
