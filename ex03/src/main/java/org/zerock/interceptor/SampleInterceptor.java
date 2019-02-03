package org.zerock.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post handle..........");
		
		Object result= modelAndView.getModel().get("res");
		
		if(result!=null) { //넘어온 값이 있으면 
			request.getSession().setAttribute("result", result); //세션에 담아주고 
			response.sendRedirect("/doA"); // doA redirect 보냄 
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("pre handle..............");
		
		HandlerMethod method =(HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean: "+ method.getBean());
		System.out.println("Method: "+methodObj);
		return true;
	}
	
		

}
