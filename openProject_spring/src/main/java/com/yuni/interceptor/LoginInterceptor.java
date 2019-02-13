package com.yuni.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		Map<String, Object> map = modelAndView.getModel();
		String referer = (String) map.get("referer");
		System.out.println("-------------------------");
		System.out.println(referer);
		System.out.println("-------------------------");

		boolean b = referer.equals("/login/loginForm");
		System.out.println(b);

//		response.sendRedirect(b?"/main":referer);
//		response.sendRedirect("/main");
		if (b) {
			modelAndView.setViewName("redirect:/main");
			System.out.println("true임");
		}else {
			System.out.println("false임");
			modelAndView.setViewName("redirect:"+referer);
		}

//		super.postHandle(request, response, handler, modelAndView);
	}

}
