//package com.controller.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.controller.action.Action;
//import com.controller.action.EmployeeListAction;
//import com.controller.action.JoinAction;
//import com.controller.action.LoginAction;
//import com.controller.action.MemberListAction;
//import com.controller.action.RegEmployeeAction;
//import com.controller.action.ajaxAction;
//import com.sun.corba.se.impl.activation.CommandHandler;
//
//@WebServlet(urlPatterns = "*.do") // .do라고 찍혀서 넘어오는 페이지 요청은 다 컨트롤러가 받아서 처리 해줌
//
//public class FrontController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
////	private void process(HttpServletRequest request,
////			 HttpServletResponse response) throws ServletException, IOException {
////			 String command = request.getParameter("cmd");
////			 CommandHandler handler = (CommandHandler)commandHandlerMap.get(command);
////			 if (handler == null) {
////			 handler = new NullHandler();
////			 }
////			 String viewPage = null;
////			 try {
////			 viewPage = handler.process(request, response);
////			 } catch (Throwable e) {
////			 throw new ServletException(e);
////			 }
////			 RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
////			 dispatcher.forward(request, response);
////			 }
////			}
////	
//
//
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		// 한글 인코딩 처리
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//
//		// getRequestURI() : "/프로젝트명/파일명(*.do)" 문자열로 반환함.
//		String uri = request.getRequestURI();
//
//		// getContextPath() : 현재 프로젝트명을 반환하는 메서드.
//		String path = request.getContextPath();
//
//		// command 문자열 변수에는 *.do
//		String command = uri.substring(path.length() + 1);
//		System.out.println("command ==> " + command);
//
//		Action action = null; // 인터페이스임 -> 사용하려면 추상메서드 구현해야 함
//								// -> void execute(HttpServletRequest request, HttpServletResponse response)
//								// throws IOException;
//		String viewPage = null;
//
//		if (command.equals("join/joinForm.do")) {
//			action = new JoinAction(); // 추상메서드 구현한 클래스 객체 생성
//			action.execute(request, response); // 구현한 메서드 사용. 메서드 인자값이 넘어오 request, response 객체 다 받아줌
//			viewPage = "/main.jsp"; // response.forward 할때 이 페이지로 넘어갈 수 있도록 설정
//			// System.out.println(viewPage);
//		} else if (command.equals("login/LoginAction.do")) {
//			action = new LoginAction();
//			action.execute(request, response);
//			viewPage = "/main.jsp";
//
//		} else if (command.equals("Memberlist.do")) {
//			action = new MemberListAction();
//			action.execute(request, response);
//			viewPage = "/memberList/Memberlist.jsp";
//		} else if (command.equals("ajaxModi.do")) {
//			action = new ajaxAction();
//			action.execute(request, response);
//
//			viewPage = "ajaxModiTest.do";
//		}
//
//		else if (command.equals("EmployeeList.do")) {
//			action = new EmployeeListAction();
//			action.execute(request, response);
//			viewPage = "/employee/employee.jsp";
//		} else if (command.equals("employee/regEmployee.do")) {
//			action = new RegEmployeeAction();
//			action = new EmployeeListAction();
//			action.execute(request, response);
//			viewPage = "/employee/employee.jsp";
//			System.out.println(viewPage);
//		} else if (command.equals("ajaxTest.do")) {
//			viewPage = "/openProject/ajax.jsp";
//			System.out.println(viewPage);
//			action = new ajaxAction();
//			action.execute(request, response);
//		}
//
//		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
//		rd.forward(request, response);
//
//	}
//}
