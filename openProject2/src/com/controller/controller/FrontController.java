package com.controller.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.controller.action.EmployeeListAction;
import com.controller.action.JoinAction;
import com.controller.action.LoginAction;
import com.controller.action.MemberListAction;
import com.controller.action.RegEmployeeAction;
import com.controller.action.ajaxAction;


@WebServlet(urlPatterns = "*.do")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("front  :  "+request.getParameter("memberId"));
		// 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// getRequestURI() : "/프로젝트명/파일명(*.do)" 문자열로 반환함.
		String uri = request.getRequestURI();
		
		// getContextPath() : 현재 프로젝트명을 반환하는 메서드.
		String path = request.getContextPath();
		
		// command 문자열 변수에는 *.do
		String command = uri.substring(path.length() + 1);
		System.out.println("command ==> " + command);
		
		Action action = null;
		String viewPage = null;
		
		if(command.equals("join/joinForm.do")) {
			action = new JoinAction();
			action.execute(request, response);
			viewPage ="/main.jsp";
			System.out.println(viewPage);
		}
			else if(command.equals("login/LoginAction.do")) {
			action = new LoginAction();
			action.execute(request, response);
			viewPage = "/main.jsp";
			// System.out.println("나오지 마라  : " +request.getAttribute("result"));
		}
			else if(command.equals("Memberlist.do")) {
			action = new MemberListAction();
			action.execute(request, response);
			viewPage="/memberList/Memberlist.jsp";
		}else if(command.equals("EmployeeList.do")) {
			action = new EmployeeListAction();
			action.execute(request, response);
			viewPage="/employee/employee.jsp";
		}else if(command.equals("employee/regEmployee.do")) {
			action = new RegEmployeeAction();
			action = new EmployeeListAction();
			action.execute(request, response);
			viewPage="/employee/employee.jsp";
			System.out.println(viewPage);
		}else if(command.equals("ajaxTest.do"))
		{
			viewPage ="/openProject/ajax.jsp";
			System.out.println(viewPage);
			action= new ajaxAction();
			action.execute(request, response);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
		
		
	}
}








