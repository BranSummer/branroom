package org.bran.branroom.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AntiDupLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUrl=request.getRequestURI();
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")==null){
			return true;
		}else{
			response.sendRedirect("/branroom/profile");
			return false;
		}
		
	}
	
}
