package com.bidnow.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrypeRequestWrapper extends HttpServletRequestWrapper  {

	public EncrypeRequestWrapper(HttpServletRequest request) {
		super(request);
		/*request에 getPramater를 재정의 하기위해서 HttpServletRequestWrapper를 상속받음
		 *이유? 바로 request를 상속을 받지 못하여서 HttpServletRequestWrapper상속 받고 그의 부모에 메소드를 오버라이딩하여 재정의!!  */
		
	}
	
	@Override
	public String getParameter(String key) {
		
		String value = "";
		if("userPwd".equals(key)) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key));
		}else {
			value= super.getParameter(key);
		}
		
		return value;
	}

}
