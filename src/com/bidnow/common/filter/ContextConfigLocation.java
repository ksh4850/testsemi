package com.bidnow.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bidnow.common.ConfigLocation;

/**
 * Servlet Filter implementation class ContextConfigLocation
 */
@WebFilter("/*")
public class ContextConfigLocation implements Filter {


	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
			
			String root = request.getServletContext().getRealPath("/");
			
			String connectionInfoPath = request.getServletContext().getInitParameter("config-location");
			
			ConfigLocation.CONNECTION_CONFIG_LOCATION = root + connectionInfoPath;
			
			System.out.println("디비접속 경로 : " + ConfigLocation.CONNECTION_CONFIG_LOCATION);
			
		}
		
		if(ConfigLocation.MAPPER_LOCATION == null) {
			String root = request.getServletContext().getRealPath("/");
			String mapperPath = request.getServletContext().getInitParameter("mapper-location");
			
			
			ConfigLocation.MAPPER_LOCATION = root + mapperPath;
			
			
		}
		
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
