package com.me.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.print("IN PRE HANDLE");
		//after sanitization
		String susername = sanitizeInput(username);
		String spassword = sanitizeInput(password);
		System.out.println("SUSERNAME IS:"+susername);
		
		request.setAttribute("username", susername);
		request.setAttribute("password",spassword);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public String sanitizeInput(String value) {
		value = value.replaceAll(" ", "_"); // Replacing white space with _
		// remove HTML tags
		value = value.replaceAll("[<>]", "");
		// remove script tag
		value = value.replaceAll("script", "");
		// remove link
		value = value.replaceAll("www.", "");
		value = value.replaceAll(".com", "");
		// Remove eval
		value = value.replaceAll("eval\\\\((.*)\\\\)", "");
		// Remove JavaScript
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
				"\"\"");
		// Remove document tag
		value = value.replaceAll("document", "");
		// Remove .write tage
		value = value.replaceAll(".write", "");
		// Replace _ with space
		value = value.replaceAll("_", " ");
		return value;
	}

	
	

}
