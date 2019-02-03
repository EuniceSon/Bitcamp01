package org.zerock.interceptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger= LoggerFactory.getLogger(AuthInterceptor.class);
	
	private void saveDest(HttpServletRequest req) {
		String uri =req.getRequestURI();
		String query =req.getQueryString();
		
		if(query==null||query.equals("null")) {
			query="";
		}else {
			query="?"+query;
		}
		
		if(req.getMethod().equals("GET")) {
			logger.info("dest: "+(uri+query));
			//어느 경로로 가고 싶었는지 저장해 놓앟다가 해당 경로로 이동시켜 줄 것임 
			req.getSession().setAttribute("dest", uri+query);
		}
	}
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session =request.getSession(); //session 생성
		
		if(session.getAttribute("login")==null) {
			logger.info("current user is not logined");
			response.sendRedirect("/user/login");
			return false;
		}
		logger.info("current user is logined");
		return true;
		
	}
	
	
	
	
}
