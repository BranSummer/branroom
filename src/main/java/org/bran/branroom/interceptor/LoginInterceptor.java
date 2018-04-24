package org.bran.branroom.interceptor;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private List<String> urlIgnore;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUrl=request.getRequestURI();
		for(String url:urlIgnore){
			if(requestUrl.indexOf(url)>0||Pattern.matches(url, requestUrl)){
				return true;
			}
		}
		
		HttpSession session=request.getSession();
		if(session!=null&&session.getAttribute("user")!=null){
			return true;
		}else{
			response.sendRedirect("/branroom/login");
			return false;
		}
		
	}

	public List<String> getUrlIgnore() {
		return urlIgnore;
	}

	public void setUrlIgnore(List<String> urlIgnore) {
		this.urlIgnore = urlIgnore;
	}
	
	
}
